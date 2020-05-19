package nist;


import utils.FunctionUtils;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Spectral {

    public static double test(String sequence) {
        DoubleStream doubleStream = sequence.chars().mapToDouble(x -> (double) x);
        double[] temp1 = doubleStream.map((x) -> x == 48 ? -1 : 1).toArray();
        double[] temp2 = new double[sequence.length()];
        double[] dft = FunctionUtils.dft(temp1, temp2);
        double[] modulus = Arrays.stream(dft).limit(sequence.length() / 2).toArray();
        double T = Math.sqrt((Math.log(1 / 0.05) * sequence.length()));
        double n0 = 0.95 * sequence.length() / 2;

        double n1 = Arrays.stream(modulus).filter(x -> x <= T && x != 0).count();

        return FunctionUtils.erfc(Math.abs((n1 - n0) / Math.sqrt(sequence.length() * 0.95 * 0.05 / 4)) / Math.sqrt(2));
    }

}
