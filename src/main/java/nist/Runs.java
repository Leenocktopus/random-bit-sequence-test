package nist;


import utils.FunctionUtils;

public class Runs {

    public static double test(String sequence) {
        double pi = FunctionUtils.getOnesInBlock(sequence) / (double) sequence.length();
        if (Math.abs(pi - 0.5) >= 2 / Math.pow(sequence.length(), 0.5)) {
            return 0.000000000000000001;
        }
        int v = 1;
        for (int i = 0; i < sequence.length() - 1; i++) {
            if (sequence.charAt(i) != sequence.charAt(i + 1))
                v++;
        }
        return FunctionUtils.erfc((Math.abs(v - 2 * sequence.length() * pi * (1 - pi)))
                / (2 * Math.sqrt(2 * sequence.length()) * pi * (1 - pi)));
    }
}
