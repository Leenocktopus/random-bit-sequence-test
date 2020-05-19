package nist;


import utils.FunctionUtils;

import java.util.Arrays;

public class CumulativeSums {

    public static double[] test(String sequence) {
        int n = sequence.length();
        int[] temp = sequence.chars()
                .map((x) -> {
                    if (x == 48) {
                        return -1;
                    }
                    return 1;
                }).toArray();
        int sum = 0;
        int[] forward = new int[temp.length];
        int[] backward = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            sum = temp[i] + sum;
            forward[i] = sum;
        }
        sum = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
            sum = temp[i] + sum;
            backward[i] = sum;
        }
        double forwardZ = phi(n, Arrays.stream(forward).map(Math::abs).max().orElse(0));
        double backwardZ = phi(n, Arrays.stream(backward).map(Math::abs).max().orElse(0));
        forwardZ = forwardZ >= 1 ? 1 : forwardZ;
        backwardZ = backwardZ >= 1 ? 1 : backwardZ;
        return new double[]{forwardZ, backwardZ};
    }

    private static double phi(int n, double z) {
        double e1 = 0, e2 = 0;
        int start = (int) Math.floor(4 * Math.floor(-n / z) + 1);
        int end = (int) Math.floor(4 * Math.floor(n / z) - 1);

        for (double i = start; i < end + 1; i++) {
            e1 += FunctionUtils.cumNormalDistribution(((4 * i + 1) * z) / Math.sqrt(n));
            e1 -= FunctionUtils.cumNormalDistribution(((4 * i - 1) * z) / Math.sqrt(n));
        }


        start = (int) Math.floor(4 * Math.floor(-n / z - 3));
        end = (int) Math.floor(4 * Math.floor(n / z) - 1);

        for (double i = start; i < end + 1; i++) {
            e2 += FunctionUtils.cumNormalDistribution(((4 * i + 3) * z) / Math.sqrt(n));
            e2 -= FunctionUtils.cumNormalDistribution(((4 * i + 1) * z) / Math.sqrt(n));
        }
        return (1 - e1) + e2;
    }


}
