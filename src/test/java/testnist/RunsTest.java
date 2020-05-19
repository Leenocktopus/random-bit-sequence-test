package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RunsTest {

    @Test
    public void testRuns() {
        assertEquals(0.147232, NistTest.runsTest("1001101011").getpValue(), 0.001);
        assertEquals(0.500798, NistTest.runsTest("11001001000011111101101010100010001000010110100" +
                "01100001000110100110001001100011001100010100010111000").getpValue(), 0.001);
        assertEquals(0.0002638, NistTest.runsTest("1010101010101").getpValue(), 0.00001);
        assertEquals(0, NistTest.runsTest("111111111111111111").getpValue(), 0.00001);

    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);//2^16
            double result = NistTest.runsTest(temp).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed runs test on sequence: " + temp);
            }
        }
    }
}
