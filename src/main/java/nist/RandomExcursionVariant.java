package nist;


import utils.FunctionUtils;

import java.util.Arrays;

public class RandomExcursionVariant {
    public static final int[] states = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static double[] test(String sequence) {
        int[] set = FunctionUtils.getExcursions(sequence);

        int J = (int) Arrays.stream(set).filter(x -> x == 0).count() - 1;
        double[] occurrences = new double[states.length];
        for (int i = 0; i < occurrences.length; i++) {
            int count = 0;
            for (int t : set) {
                if (t == states[i]) {
                    count++;
                }
            }
            occurrences[i] = FunctionUtils.erfc(Math.abs(count - J) /
                    Math.sqrt(2 * J * (4 * Math.abs(states[i]) - 2)));
        }

        return occurrences;
    }


}
