package nist;


import utils.GammaUtils;
import utils.TemplateUtils;

import java.util.Arrays;

public class Entropy {

    public static double test(String sequence, int blockSize) {
        String[] sequences = {sequence + sequence.substring(0, blockSize - 1), sequence + sequence.substring(0, blockSize)};
        int n = sequence.length();
        double[] sums = new double[2];
        for (int i = 0; i <= 1; i++) {
            String[] temp = TemplateUtils.getTemplates(blockSize + i);
            double[] frequencies = new double[temp.length];
            for (int j = 0; j < temp.length; j++) {
                int k = blockSize + i;

                while (k <= sequences[i].length()) {
                    if (sequences[i].substring(k - blockSize - i, k).equals(temp[j])) {
                        frequencies[j]++;
                    }
                    k++;

                }
            }
            sums[i] = Arrays.stream(frequencies)
                    .map(x -> x / n)
                    .map(x -> {
                        if (x != 0) {
                            return x * (Math.log(x));
                        } else {
                            return x;
                        }
                    }).sum();

        }


        double chiSquared = 2 * n * (Math.log(2) - (sums[0] - sums[1]));

        return GammaUtils.gammaFunction(Math.pow(2, blockSize - 1), chiSquared / 2);
    }
}
