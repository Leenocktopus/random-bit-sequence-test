package nist;


import utils.GammaUtils;

public class LongestRunOfOnes {
    public static final double[] PI_COEFFICIENTS = {.2148, .3672, .2305, .1875};
    public static int blockSize = 8; // block length - 8 - Nist Recommendation

    public static double test(String sequence) {
        int[] amounts = new int[sequence.length() / blockSize];
        int k = 0;
        for (int i = 0; i < sequence.length() / blockSize * blockSize; i += blockSize) {
            int times = 0;
            int temp = 0;
            for (int j = i; j < i + 8; j++) {
                if (sequence.charAt(j) == '1') {
                    times++;
                } else {
                    // comparing length with previous subsequence to get the longest
                    temp = Math.max(temp, times);
                    times = 0;
                }
            }
            temp = Math.max(temp, times);
            amounts[k] = temp; //writing max subsequence to array
            k++;
        }
        int[] v = new int[4];
        for (int i : amounts) {
            if (i <= 1) {
                v[0]++;
            } else if (i >= 4) {
                v[3]++;
            } else {
                v[i - 1]++;
            }
        }

        double chiSquared = 0;
        for (int i = 0; i < v.length; i++) {
            chiSquared += Math.pow((v[i] - 16 * PI_COEFFICIENTS[i]), 2) / (16 * PI_COEFFICIENTS[i]);
        }

        return GammaUtils.gammaFunction(3. / 2, chiSquared / 2);
    }
}
