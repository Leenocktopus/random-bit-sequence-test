package nist;


import utils.MatrixUtils;

public class BinaryMatrixRank {
    public static final double[] COEFFICIENTS = {.2888, .5776, .1336};


    public static double test(String sequence, int matrixSize) {
        int[][][] matrices = MatrixUtils.getMatricesFromSequence(sequence, matrixSize);
        int[] ranks = new int[matrices.length];
        for (int i = 0; i < matrices.length; i++) {
            ranks[i] = MatrixUtils.computeRank(matrices[i]);
        }
        int maxRank = matrices[0].length;
        int[] amounts = new int[3];
        for (int i : ranks) {
            if (i == maxRank) {
                amounts[2]++;
            } else if (i == maxRank - 1) {
                amounts[1]++;
            } else {
                amounts[0]++;
            }
        }
        double chiSquared = 0;

        for (int i = 0; i < amounts.length; i++) {
            double n = COEFFICIENTS[i] * (sequence.length() / (matrixSize * matrixSize));

            chiSquared += Math.pow((amounts[amounts.length - i - 1] - n), 2) / n;
        }
        return Math.pow(Math.E, -chiSquared / 2);
    }

}

