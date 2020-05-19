package nist;


import utils.FunctionUtils;
import utils.GammaUtils;

public class BlockFrequency {

    public static double test(String sequence, int blockSize) {
        int times = sequence.length() / blockSize;
        double[] proportions = new double[times];
        int j = 0;
        for (int i = 0; i <= sequence.length() - blockSize; i += blockSize) {
            proportions[j++] = Math.pow(
                    FunctionUtils.getOnesInBlock(sequence.substring(i, i + blockSize)) / (double) blockSize - 0.5, 2);
        }
        double sum = 0;
        for (double proportion : proportions) {
            sum += proportion;
        }
        return GammaUtils.gammaFunction(times / 2., 4 * blockSize * sum / 2);
    }
}
