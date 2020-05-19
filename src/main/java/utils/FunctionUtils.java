package utils;

import java.util.Arrays;

public class FunctionUtils {


    private static double erf(double x) {
        double c = 1.0 / (1.0 + 0.5 * Math.abs(x));
        double result = 1 - c * Math.exp(-x * x - 1.26551223 +
                c * (1.00002368 + c * (0.37409196 + c * (0.09678418 + c * (-0.18628806 + c * (0.27886807 +
                        c * (-1.13520398 + c * (1.48851587 + c * (-0.82215223 + c * (0.17087277))))))))));
        if (x >= 0) {
            return result;
        }
        return -result;
    }

    public static double erfc(double x) {
        double result = 1 - erf(x);
        return result <= 1.0000000300000005 && result > 1 ? 1 : result;
    }

    public static double cumNormalDistribution(double x) {
        if (x > 0) {
            x = erf(x / Math.sqrt(2));
        } else {
            x = -erf(-x / Math.sqrt(2));
        }
        return 0.5 * (1 + x);
    }

    public static double[] dft(double[] real, double[] imag) {
        if (real.length == 0 || imag.length == 0) {
            throw new IllegalArgumentException("Real and Imaginary arrays can't be empty");
        }
        double[] realResult = new double[real.length];
        double[] imagResult = new double[real.length];
        for (int k = 0; k < real.length; k++) {
            for (int t = 0; t < real.length; t++) {
                double angle = (2.0 * Math.PI * t / real.length) * k;
                realResult[t] += real[k] * Math.cos(angle);
                imagResult[t] += real[k] * Math.sin(angle);
                realResult[t] -= imag[k] * Math.sin(angle);
                imagResult[t] += imag[k] * Math.cos(angle);
            }
        }

        for (int i = 0; i < realResult.length; i++) {
            realResult[i] = Math.sqrt(Math.pow(imagResult[i], 2) + Math.pow(realResult[i], 2));
        }
        return realResult;
    }

    public static int berlekampMassey(String sequence) {
        if (sequence.length() == 0) {
            throw new IllegalArgumentException("Sequence can't contain less than 1 character");
        }
        int[] s = new int[sequence.length()];
        for (int i = 0; i < sequence.length(); i++) {
            s[i] = Character.getNumericValue(sequence.charAt(i));
        }
        int[] c = new int[sequence.length()];
        int[] b = new int[sequence.length()];
        b[0] = 1;
        c[0] = 1;
        int l = 0;
        int n = 0;
        int m = -1;
        while (n < sequence.length()) {
            int d = s[n];
            for (int i = 1; i <= l; i++) {
                d += s[n - i] * c[i];
            }

            d %= 2;

            int[] p = new int[sequence.length()];
            if (d == 1) {
                int[] t = Arrays.copyOf(c, c.length);
                for (int i = 0; i < l; i++) {
                    if (b[i] == 1) {
                        p[i + n - m] = 1;
                    }
                }
                for (int i = 0; i < sequence.length(); i++) {
                    c[i] = p[i] ^ c[i];
                }
                if (l <= (n / 2)) {
                    l = n + 1 - l;
                    m = n;
                    b = Arrays.copyOf(t, t.length);
                }
            }
            n++;

        }
        return l;
    }

    public static int getOnesInBlock(String sequence) {
        if (sequence.length() == 0) return 0;
        if (sequence.charAt(0) == '1') return 1 + getOnesInBlock(sequence.substring(1));
        return getOnesInBlock(sequence.substring(1));
    }

    public static int[] getExcursions(String sequence) {
        int[] temp = sequence.chars()
                .map((x) -> {
                    if (x == 48) {
                        return -1;
                    }
                    return 1;
                }).toArray();
        int sum = 0;
        int[] set = new int[temp.length + 2];
        set[0] = 0;
        set[set.length - 1] = 0;
        for (int i = 0; i < temp.length; i++) {
            sum = temp[i] + sum;
            set[i + 1] = sum;
        }
        return set;
    }

    public static long binomialCoefficient(long k, long m) {
        if (m > k || (k == 0 && m == -1)) {
            return 0;
        } else if (k < 0 || m < 0) {
            return 0;
        }

        long result = 1L;
        for (int i = 1; i <= m; ++i) {
            result *= k--;
            result /= i;
        }
        return result;
    }

    public static long functionZ(int a, int b) {
        if (a == b && a == 0) {
            return 1L;
        } else if (a >= b && b >= 0) {
            return binomialCoefficient(a - 1, b - 1);
        } else {
            return 0L;
        }
    }
}

