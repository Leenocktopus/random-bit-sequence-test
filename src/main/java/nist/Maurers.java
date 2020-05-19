package nist;


import utils.FunctionUtils;

import java.util.Arrays;

public class Maurers {
    public static final double[][] theoreticalValues = {
            {2, 1.5374383, 1.338},
            {3, 2.4016068, 1.9013347},
            {4, 3.3112247, 2.3577369},
            {5, 4.2534266, 2.7045528},
            {6, 5.2177052, 2.9540324},
            {7, 6.1962507, 3.1253919},
            {8, 7.1836656, 3.2386622},
            {9, 8.1764248, 3.3112009},
            {10, 9.1723243, 3.3564569},
            {11, 10.1700323, 3.3840870},
            {12, 11.1687649, 3.4006541},
            {13, 12.1680703, 3.4104380},
            {14, 13.1676926, 3.4161418},
            {15, 14.1674884, 3.4194304},
            {16, 15.1673788, 3.4213083}};


    public static double test(String sequence, int blockSize, int blocksInInitSegment) {
        int k = (sequence.length() / blockSize - blocksInInitSegment);
        String initSegment = sequence.substring(0, blockSize * blocksInInitSegment);
        String testSegment = sequence.substring(blockSize * blocksInInitSegment, blockSize * blocksInInitSegment + k * blockSize);

        //Create init segment table
        int[] table = new int[(int) Math.pow(2, blockSize)];
        for (int i = 0; i < initSegment.length() / blockSize; i++) {
            int lastOccurrence = Integer.valueOf(initSegment.substring(i * blockSize, i * blockSize + blockSize), 2);
            table[lastOccurrence] = i + 1;
        }

        // Create test segment table
        int[][] testTable = new int[testSegment.length() / blockSize + 1][table.length];
        testTable[0] = Arrays.copyOf(table, table.length);
        for (int i = 0; i < testTable.length - 1; i++) {
            int lastOccurrence = Integer.valueOf(testSegment.substring(i * blockSize, i * blockSize + blockSize), 2);
            table[lastOccurrence] = i + 1 + initSegment.length() / blockSize;
            testTable[i + 1] = Arrays.copyOf(table, table.length);
        }
        //Compute log differences and function "f"
        double logSum = 0;
        for (int i = 1; i < testTable.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (testTable[i][j] != testTable[i - 1][j]) {
                    logSum += Math.log((double) testTable[i][j] - (double) testTable[i - 1][j]) / Math.log(2);
                }
            }

        }
        double f = logSum / k;
        return FunctionUtils.erfc(Math.abs((f - theoreticalValues[blockSize - 2][1])
                / (Math.sqrt(2) * Math.sqrt(theoreticalValues[blockSize - 2][2]))));
    }
}
