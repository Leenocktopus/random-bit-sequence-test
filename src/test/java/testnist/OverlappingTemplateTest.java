package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class OverlappingTemplateTest {

    @Test
    public void testResult() {
        assertEquals(0.350636, NistTest.overlappingTemplateTest(
                "10111011110010110100011100101110111110000101101001", 10, "11").getpValue(), 0.0001);
        assertEquals(0.030906, NistTest.overlappingTemplateTest(
                "11111111111111111111111111111", 10, "11").getpValue(), 0.0001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);//2^16
            double result = NistTest.overlappingTemplateTest(temp, r.nextInt(temp.length() - 2) + 3,
                    Integer.toBinaryString(r.nextInt(1) + 2)).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed spectral test on sequence: " + temp);
            }
        }
    }
}
