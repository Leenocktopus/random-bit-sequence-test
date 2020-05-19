package md;


import utils.FunctionUtils;
import utils.TemplateUtils;

public class Six extends MdStatistic {

    //{k1 = n(tt*), k2 = n(tt*t)}
    protected double test(String sequence) {
        int k1 = TemplateUtils.countOverlapping(sequence, "01");
        int k2 = TemplateUtils.countOverlapping(sequence, "010");
        double total = 0;
        for (int m1 = k1; m1 <= sequence.length() - k1; m1++) {
            int m0 = sequence.length() - m1;
            for (int k = k1 - 1; k <= k1; k++) {
                total += FunctionUtils.binomialCoefficient(k, k2) *
                        FunctionUtils.binomialCoefficient(m0 - k, k1 - k2) * FunctionUtils.functionZ(m1, k + 1);
            }
        }
        double c = k1 == k2 && k1 == 0 ? 1 : 0;
        return 1 / Math.pow(2, sequence.length()) * (total + c);
    }
}
