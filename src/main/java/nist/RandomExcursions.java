package nist;


import utils.FunctionUtils;
import utils.GammaUtils;

import java.util.Arrays;

public class RandomExcursions {
    public static final double[][] pi = {{0.5000000000, 0.25000000000, 0.12500000000, 0.06250000000, 0.03125000000, 0.0312500000},
            {0.7500000000, 0.06250000000, 0.04687500000, 0.03515625000, 0.02636718750, 0.0791015625},
            {0.8333333333, 0.02777777778, 0.02314814815, 0.01929012346, 0.01607510288, 0.0803755143},
            {0.8750000000, 0.01562500000, 0.01367187500, 0.01196289063, 0.01046752930, 0.0732727051}};
    public static final int[] states = {-4, -3, -2, -1, 1, 2, 3, 4};

    public static double[] test(String sequence) {
        int[] set = FunctionUtils.getExcursions(sequence);
        int J = (int) Arrays.stream(set).filter(x -> x == 0).count() - 1;
        int[][] table = new int[8][J];
        int cycle = 0;
        for (int i = 1; i < set.length; i++) {
            if (set[i] != 0) {
                if (set[i] <= 4 && set[i] >= -4) {
                    if (set[i] < 0) {
                        table[4 + set[i]][cycle]++;
                    } else {
                        table[3 + set[i]][cycle]++;
                    }
                }
            } else {
                cycle++;
            }
        }
        int[][] pTable = new int[8][6];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] > 5) {
                    pTable[i][5]++;
                } else {
                    pTable[i][table[i][j]]++;
                }

            }
        }
        double[] results = new double[states.length];
        for (int i = 0; i < states.length; i++) {
            double resSum = 0;
            for (int j = 0; j < pTable[0].length; j++) {
                resSum += Math.pow((pTable[i][j] - J * pi[Math.abs(states[i]) - 1][j]), 2) / (J * pi[Math.abs(states[i]) - 1][j]);

            }
            results[i] = GammaUtils.gammaFunction(5. / 2, resSum / 2);

        }
        return results;
    }

}
