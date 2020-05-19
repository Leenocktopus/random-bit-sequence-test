package nist;


import utils.GammaUtils;
import utils.TemplateUtils;

public class Serial {


    public static double[] test(String sequence, int blockSize) {


        String sequence1 = sequence + sequence.substring(0, blockSize - 1);
        String sequence2 = sequence + sequence.substring(0, blockSize - 2);
        String sequence3 = sequence + sequence.substring(0, blockSize - 3);
        String[] sequences = new String[]{sequence1, sequence2, sequence3};
        double[] results = new double[3];
        int[] blockSizes = new int[]{blockSize, blockSize - 1, blockSize - 2};
        for (int i = 0; i < sequences.length; i++) {
            String[] temp = TemplateUtils.getTemplates(blockSizes[i]);
            double total = 0;
            for (String s : temp) {
                total += Math.pow(TemplateUtils.countOverlapping(sequences[i], s), 2);
            }
            results[i] = Math.pow(2, blockSizes[i]) / sequence.length() * total - sequence.length();

        }
        double res1 = GammaUtils.gammaFunction(Math.pow(2, blockSize - 2), (results[0] - results[1]) / 2);
        double res2 = GammaUtils.gammaFunction(Math.pow(2, blockSize - 3), (results[0] - 2 * results[1] + results[2]) / 2);

        return new double[]{res1, res2};
    }
}
