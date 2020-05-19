package nist;


import utils.FunctionUtils;

import java.util.stream.IntStream;

public class Frequency {

    public static double test(String sequence) {
        IntStream s = sequence.chars();

        double sum = s.parallel()
                .map(n -> n == 49 ? 1 : -1)
                .sum();
        double sObs = Math.abs(sum) / Math.pow(sequence.length(), 1. / 2.);
        return FunctionUtils.erfc(sObs / Math.pow(2, 1. / 2.));
    }
}
