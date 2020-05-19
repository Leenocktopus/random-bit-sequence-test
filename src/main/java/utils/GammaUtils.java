package utils;


public class GammaUtils {


    private static final int MAX_ITER = 200;
    private static final double DELTA = 3.0e-8;


    private static double gammaLn(double x) {


        final double[] coeff = {76.18009172947146, -86.50532032941677,
                24.01409824083091, -1.231739572450155, 0.1208650973866179e-2,
                -0.5395239384953e-5};
        double y = x;
        double ser = 1.000000000190015;
        for (int j = 0; j <= 5; j++) {
            ser += coeff[j] / ++y;
        }

        double temp = x + 5.5;
        temp -= (x + 0.5) * Math.log(temp);
        return -temp + Math.log(2.5066282746310005 * ser / x);
    }


    public static double gammaFunction(double a, double x) {
        if (a <= 0.0) {
            throw new IllegalArgumentException("Illegal parameter a: <= 0");
        } else {
            if (x < (a + 1.0)) {
                return 1 - gser(a, x);
            } else {
                return 1 - (1.0 - gcf(a, x));
            }
        }
    }


    private static double gser(double a, double x) {
        double gln = gammaLn(a);
        if (x <= 0.0) {
            if (x < 0.0)
                throw new IllegalArgumentException("Illegal parameter x: < 0");
            return 0.0;
        } else {
            double ap = a;
            double delta = 1.0 / a;
            double sum = 1.0 / a;
            for (int n = 1; n <= MAX_ITER; n++) {
                delta *= x / ++ap;
                sum += delta;
                if (Math.abs(delta) < Math.abs(sum) * DELTA) {
                    return sum * Math.exp(-x + a * Math.log(x) - gln);
                }
            }
            return 0;//throw new IllegalArgumentException("a is too large");
        }
    }

    private static double gcf(double a, double x) {
        double b = x + 1.0 - a;
        double c = 1.0 / Double.MIN_VALUE;
        double d = 1.0 / b;
        double h = d;
        for (int i = 1; i <= MAX_ITER; i++) {
            double an = -i * (i - a);
            b += 2;
            d = an * d + b;
            if (Math.abs(d) < Double.MIN_VALUE) {
                d = Double.MIN_VALUE;
            }
            c = b + an / c;
            if (Math.abs(c) < Double.MIN_VALUE) {
                c = Double.MIN_VALUE;
            }
            d = 1.0 / d;
            double delta = d * c;
            h *= delta;
            if (Math.abs(delta - 1) < DELTA)
                break;
        }

        return Math.exp(-x + a * Math.log(x) - gammaLn(a)) * h;
    }

}