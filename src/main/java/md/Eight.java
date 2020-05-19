package md;


import utils.FunctionUtils;
import utils.TemplateUtils;

public class Eight extends MdStatistic {

    //{k1 = n(tt), k2 = n(t*tt*)}
    protected double test(String sequence) {
        int k1 = TemplateUtils.countOverlapping(sequence, "00");
        int k2 = TemplateUtils.countOverlapping(sequence, "101");
        double total = 0;
        for (int m1 = 0; m1 <= sequence.length(); m1++) {
            int m0 = sequence.length() - m1;
            int a = m1 - k1;
            double c1 = FunctionUtils.binomialCoefficient(a - 2, k2);
            double c2 = FunctionUtils.binomialCoefficient(k1 + 1, a - k2 - 1);
            double c3 = FunctionUtils.functionZ(m0, a - 1);
            double c4 = FunctionUtils.binomialCoefficient(a, k2);
            double c5 = FunctionUtils.binomialCoefficient(m0 - 1, a);
            double c6 = FunctionUtils.functionZ(k1, a - k2);
            double c7 = FunctionUtils.binomialCoefficient(a - 1, k2);
            double c8 = FunctionUtils.binomialCoefficient(k1, a - k2 - 1);
            double c9 = FunctionUtils.binomialCoefficient(m0 - 1, a - 1);
            double c10 = a - 1 == k2 && k2 == m0 && m0 == 0 ? 1 : 0;
            total += c1 * c2 * c3 + c4 * c5 * c6 + 2 * c7 * c8 * c9 + c10;
        }
        return 1 / Math.pow(2, sequence.length()) * total;
    }
}
