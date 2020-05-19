package md;

import utils.FunctionUtils;
import utils.TemplateUtils;

public class One extends MdStatistic {

    //{k1 = n(tt*), k2 = n(t1t*) + n(t0t*)}
    protected double test(String sequence) {
        int k1 = TemplateUtils.countOverlapping(sequence, "01");
        int k2 = TemplateUtils.countOverlapping(sequence, "011") +
                TemplateUtils.countOverlapping(sequence, "001");
        double total = 0;
        for (int m1 = k1; m1 <= sequence.length() - k1; m1++) {
            int m0 = sequence.length() - m1;
            for (int delta0 = 0; delta0 <= 2 * k1 - k2; delta0++) {
                for (int delta1 = 0; delta1 <= 2 * k1 - k2; delta1++) {
                    if (delta0 + delta1 == 2 * k1 - k2) {
                        total += FunctionUtils.binomialCoefficient(k1, delta0) *
                                FunctionUtils.binomialCoefficient(m0 - k1, k1 - delta0) *
                                FunctionUtils.binomialCoefficient(k1, delta1) *
                                FunctionUtils.binomialCoefficient(m1 - k1, k1 - delta1);
                    }
                }
            }
        }
        return 1 / Math.pow(2, sequence.length()) * total;
    }
}
