package nist;


import utils.GammaUtils;
import utils.TemplateUtils;

public class OverlappingTemplate {
    public static final double[] COEFFICIENTS = {0.364091, 0.185659, 0.139381, 0.100571, 0.0704323, 0.139865};


    public static double test(String sequence, Integer blockSize, String template) {
        int n = sequence.length() / blockSize;
        double[] w = new double[6];
        for (int i = 0; i < n; i++) {
            int res = TemplateUtils.countOverlapping(sequence.substring(i * blockSize, i * blockSize + blockSize), template);

            if (res >= w.length) {
                w[w.length - 1]++;
            } else {
                w[res]++;
            }
        }
        double chiSquared = 0;
        for (int i = 0; i < w.length; i++) {
            chiSquared += Math.pow(w[i] - n * COEFFICIENTS[i], 2) / (n * COEFFICIENTS[i]);
        }

        return GammaUtils.gammaFunction(5. / 2, chiSquared / 2);
    }

}


