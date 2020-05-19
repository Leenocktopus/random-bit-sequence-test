package md;


import utils.FunctionUtils;
import utils.TemplateUtils;

public class Seven extends MdStatistic {

    //{k1 = n(tt*), k2 = n(ttt), k3 = n(tt*t)}
    protected double test(String sequence) {
        int k1 = TemplateUtils.countOverlapping(sequence, "01");
        int k2 = TemplateUtils.countOverlapping(sequence, "000");
        int k3 = TemplateUtils.countOverlapping(sequence, "010");
        double total = 0;
        for (int m1 = k1; m1 <= sequence.length() - k1; m1++) {
            int m0 = sequence.length() - m1;
            double subTotal = 0;
            for (int i = k1; i <= k1 + 1; i++) {
                subTotal += FunctionUtils.binomialCoefficient(i, k2 - m1 + 2 * i) *
                        FunctionUtils.binomialCoefficient(i - 1, k3) *
                        FunctionUtils.functionZ(m1 - i, m1 - i - k2) *
                        FunctionUtils.binomialCoefficient(m0 - i + 1, k1 - k3) * (m1 >= 2 ? 1 : 0);
            }
            double z = (m1 == 0 ? 1 : 0) * (!(k1 + k2 + k3 >= 1) ? 1 : 0) + (m1 == 1 ? 1 : 0) *
                    (!(k2 + k3 >= 1) ? 1 : 0) * (!(k2 == 0 && k3 == 0 && k1 >= 2) ? 1 : 0) *
                    ((k1 == 0 && k2 == 0 && k3 == 0 ? 1 : 0) + (sequence.length() - 1) *
                            (k1 == 1 && k2 == 0 && k3 == 0 ? 1 : 0));
            total += subTotal + z;
        }
        return 1 / Math.pow(2, sequence.length()) * total;
    }
}
