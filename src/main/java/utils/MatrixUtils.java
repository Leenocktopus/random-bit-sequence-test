package utils;

public class MatrixUtils {

    public static int[][][] getMatricesFromSequence(String sequence, int matrixSize) {
        int n = sequence.length() / (matrixSize * matrixSize);
        if (n < 1) {
            throw new IllegalArgumentException("Matrix and sequence length should be such that " +
                    "size*size is less than sequence length");
        }
        int[][][] matrices = new int[n][matrixSize][matrixSize];
        for (int i = 0; i < n * matrixSize * matrixSize; i += matrixSize * matrixSize) {
            String temp = sequence.substring(i, i + matrixSize * matrixSize);
            int j = 0;
            for (int k = 0; k < matrixSize; k++) {
                for (int l = 0; l < matrixSize; l++) {
                    matrices[i / (matrixSize * matrixSize)][k][l] = Character.getNumericValue(temp.charAt(j));
                    j++;
                }
            }
        }
        return matrices;
    }

    public static int computeRank(int[][] matrix) {
        if (matrix.length < 2) {
            throw new IllegalArgumentException("Matrix should be at least 2x2");
        }
        for (int i = 0; i < matrix.length; i++) {
            int max = i;
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[j][i] > matrix[max][i]) {
                    max = j;
                }
            }
            int[] temp = matrix[i];
            matrix[i] = matrix[max];
            matrix[max] = temp;
            for (int k = i + 1; k < matrix.length; k++) {
                double coeff = (matrix[i][i] == 0) ? 0 : matrix[k][i] / matrix[i][i];
                for (int j = i; j < matrix.length; j++) {
                    matrix[k][j] -= coeff * matrix[i][j];
                }
            }
        }
        int rank = matrix.length;
        for (int[] m : matrix) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum += m[j];
            }
            if (sum == 0) {
                rank--;
            }
        }
        return rank;
    }

}
