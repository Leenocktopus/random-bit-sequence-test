package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class LinaerComplexityTest {

    @Test
    public void testResult() {
        assertEquals(0.0000000558,
                NistTest.linearComplexityTest("1101011110001", 13).getpValue(), 0.000000001);

    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4)
                    + Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);
            double result = NistTest.linearComplexityTest(temp, r.nextInt(temp.length() - 2) + 2).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed linear complexity test on sequence: " + temp);
            }
        }
    }

}
