package testmd;

import org.junit.Test;
import utils.TemplateUtils;

import static org.junit.Assert.assertEquals;

public class TestUtils {


    public static double impericalTwoFromThree(String sequence, String tmpl1, String tmpl2, String tmpl3) {
        int k1 = TemplateUtils.countOverlapping(sequence, tmpl1);
        int k2 = TemplateUtils.countOverlapping(sequence, tmpl2) + TemplateUtils.countOverlapping(sequence, tmpl3);
        double count = 0;
        for (long i = 0; i < Math.pow(2, sequence.length()); i++) {
            String temp = Long.toBinaryString((1L << sequence.length()) | i).substring(1);
            if (TemplateUtils.countOverlapping(temp, tmpl1) == k1 && TemplateUtils.countOverlapping(temp, tmpl2) + TemplateUtils.countOverlapping(temp, tmpl3) == k2)
                count++;
        }

        return count / Math.pow(2, sequence.length());
    }

    public static double impericalThreeFromThree(String sequence, String tmpl1, String tmpl2, String tmpl3) {

        int k1 = TemplateUtils.countOverlapping(sequence, tmpl1);
        int k2 = TemplateUtils.countOverlapping(sequence, tmpl2);
        int k3 = TemplateUtils.countOverlapping(sequence, tmpl3);
        double count = 0;
        for (long i = 0; i < Math.pow(2, sequence.length()); i++) {
            String temp = Long.toBinaryString((1L << sequence.length()) | i).substring(1);
            if (TemplateUtils.countOverlapping(temp, tmpl1) == k1 && TemplateUtils.countOverlapping(temp, tmpl2) == k2 && TemplateUtils.countOverlapping(temp, tmpl3) == k3)
                count++;
        }

        return count / Math.pow(2, sequence.length());
    }

    public static double impericalTwoFromTwo(String sequence, String tmpl1, String tmpl2) {

        int k1 = TemplateUtils.countOverlapping(sequence, tmpl1);
        int k2 = TemplateUtils.countOverlapping(sequence, tmpl2);
        double count = 0;
        for (long i = 0; i < Math.pow(2, sequence.length()); i++) {
            String temp = Long.toBinaryString((1L << sequence.length()) | i).substring(1);
            if (TemplateUtils.countOverlapping(temp, tmpl1) == k1 && TemplateUtils.countOverlapping(temp, tmpl2) == k2)
                count++;
        }
        return count / Math.pow(2, sequence.length());
    }

    @Test
    public void checkUtils() {
        assertEquals(0.5, impericalTwoFromTwo("101", "01", "000"), 0.001);
        assertEquals(0.25, impericalTwoFromThree("101000", "01", "000", "111"),
                0.001);
        assertEquals(0.1875, impericalThreeFromThree("101000", "01", "011", "111"),
                0.001);
    }


}
