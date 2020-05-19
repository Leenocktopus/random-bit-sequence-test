package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class NonOverlappingTemplateTest {

    @Test
    public void testResult() {
        assertEquals(0.344154, NistTest.nonOverlappingTemplateTest(
                "10100100101110010110", 10, "001").getpValue(), 0.0001);
        assertEquals(0.000303, NistTest.nonOverlappingTemplateTest(
                "00000000000000000000000000000", 10, "11").getpValue(), 0.0001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);//2^16
            double result = NistTest.nonOverlappingTemplateTest(temp, r.nextInt(temp.length() - 2) + 3,
                    Integer.toBinaryString(r.nextInt(1) + 2)).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed spectral test on sequence: " + temp);
            }
        }
    }

}
