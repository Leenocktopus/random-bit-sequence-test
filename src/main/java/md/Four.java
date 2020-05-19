package md;


import utils.FunctionUtils;
import utils.TemplateUtils;

public class Four extends MdStatistic {

    //{k1 = n(tt*), k2 = n(t1t) + n(t0t)}
    protected double test(String sequence) {
        int k1 = TemplateUtils.countOverlapping(sequence, "01");
        int k2 = TemplateUtils.countOverlapping(sequence, "010") +
                TemplateUtils.countOverlapping(sequence, "000");
        double total = 0;
        for (int m1 = k1; m1 <= sequence.length() - k1; m1++) {
            int m0 = sequence.length() - m1;
            for (int delta0 = 0; delta0 <= k2; delta0++) {
                for (int delta1 = 0; delta1 <= k2; delta1++) {
                    if (delta0 + delta1 == k2) {
                        for (int i = k1; i <= k1 + 1; i++) {
                            double c = m1 >= 2 ? 1 : 0;
                            total += FunctionUtils.binomialCoefficient(i - 1, delta1) *
                                    FunctionUtils.binomialCoefficient(i, delta0 - m1 + 2 * i) *
                                    FunctionUtils.binomialCoefficient(m0 - i + 1, k1 - delta1) *
                                    FunctionUtils.functionZ(m1 - i, m1 - i - delta0) * c;
                        }
                    }
                }
            }
            double z = (m1 == 0 ? 1 : 0) * (!(k1 + k2 >= 1) ? 1 : 0) +
                    (m1 == 1 ? 1 : 0) * (!(k2 >= 1) ? 1 : 0) * (!(k2 == 0 && k1 >= 2) ? 1 : 0) *
                            ((k1 == 0 && k2 == 0 ? 1 : 0) + (sequence.length() - 1) * (k1 == 1 && k2 == 0 ? 1 : 0));
            total += z;
        }
        return 1 / Math.pow(2, sequence.length()) * total;
    }
}
