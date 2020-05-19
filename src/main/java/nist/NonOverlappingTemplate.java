package nist;


import utils.GammaUtils;
import utils.TemplateUtils;

import java.util.Arrays;

public class NonOverlappingTemplate {


    public static double test(String sequence, Integer blockSize, String template) {
        int tmplSize = template.length();
        int n = sequence.length() / blockSize;
        double[] w = new double[n];
        for (int i = 0; i < n; i++) {
            w[i] = TemplateUtils.countNonOverlapping(
                    sequence.substring(i * blockSize, i * blockSize + blockSize), template);
        }

        double mean = (blockSize - tmplSize + 1.) / Math.pow(2, tmplSize);
        double variance = blockSize * (1. / Math.pow(2, tmplSize) - (2. * tmplSize - 1) / Math.pow(2, 2 * tmplSize));

        double chiSquared = Arrays.stream(w)
                .map(x -> Math.pow(x - mean, 2))
                .sum();
        chiSquared /= variance;

        return GammaUtils.gammaFunction(n / 2., chiSquared / 2);
    }


}
