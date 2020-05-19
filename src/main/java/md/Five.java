package md;

import utils.FunctionUtils;
import utils.TemplateUtils;

public class Five extends MdStatistic {

    //{k1 = n(tt*), k2 = n(ttt)}
    protected double test(String sequence) {
        int k1 = TemplateUtils.countOverlapping(sequence, "01");
        int k2 = TemplateUtils.countOverlapping(sequence, "000");
        double total = 0;
        for (int m1 = k1; m1 <= sequence.length() - k1; m1++) {
            int m0 = sequence.length() - m1;
            double subTotal = 0;
            for (int k = k1; k <= k1 + 1; k++) {
                subTotal += FunctionUtils.binomialCoefficient(k, m1 - k2 - k) *
                        FunctionUtils.functionZ(m1 - k, m1 - k - k2);
            }
            total += FunctionUtils.binomialCoefficient(m0, k1) * subTotal;
        }
        return 1 / Math.pow(2, sequence.length()) * total;
    }
}
