package nist;


import utils.FunctionUtils;
import utils.GammaUtils;

public class LinearComplexity {
    public static final double[] pi = {0.010417, 0.03125, 0.125, 0.5, 0.25, 0.0625, 0.020833};


    public static double test(String sequence, int blockSize) {

        int[] linearComplexity = new int[sequence.length() / blockSize];
        for (int i = 0; i < linearComplexity.length; i++) {
            linearComplexity[i] = FunctionUtils.berlekampMassey(sequence.substring(i * blockSize, i * blockSize + blockSize));
        }

        double mean = blockSize / 2. + (9 + Math.pow(-1, blockSize + 1)) / 36 - (blockSize / 3. + 2 / 9.) / Math.pow(2, blockSize);

        int[] v = new int[7];
        for (int value : linearComplexity) {
            double t = Math.pow(-1, blockSize) * (value - mean) + 2 / 9.;

            if (t <= -2.5) {
                v[0]++;
            } else if (t <= -1.5) {
                v[1]++;
            } else if (t <= -0.5) {
                v[2]++;
            } else if (t <= 0.5) {
                v[3]++;
            } else if (t <= 1.5) {
                v[4]++;
            } else if (t <= 2.5) {
                v[5]++;
            } else {
                v[6]++;
            }
        }
        double chiSquared = 0;
        for (int i = 0; i < v.length; i++) {
            chiSquared += Math.pow(v[i] - linearComplexity.length * pi[i], 2) / (linearComplexity.length * pi[i]);
        }


        return GammaUtils.gammaFunction(7 / 2., chiSquared / 2);
    }
}
