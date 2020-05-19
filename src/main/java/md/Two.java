package md;

import utils.FunctionUtils;
import utils.TemplateUtils;

public class Two extends MdStatistic {

    //{k1 = n(tt*), k2 = n(ttt*)}
    protected double test(String sequence) {
        int k1 = TemplateUtils.countOverlapping(sequence, "01");
        int k2 = TemplateUtils.countOverlapping(sequence, "001");
        int total = 0;
        for (int m1 = k1; m1 <= sequence.length() - k1; m1++) {
            int m0 = sequence.length() - m1;
            total += FunctionUtils.binomialCoefficient(k1, k2) * FunctionUtils.binomialCoefficient(m1 - k1, k2)
                    * FunctionUtils.binomialCoefficient(m0, k1);

        }
        return 1 / Math.pow(2, sequence.length()) * total;
    }

}
