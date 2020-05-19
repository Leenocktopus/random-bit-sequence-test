package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class FrequencyTest {

    @Test
    public void testResult() {
        assertEquals(0.527089, NistTest.frequencyTest("1011010101").getpValue(), 0.001);
        assertEquals(0.109599, NistTest
                .frequencyTest("11001001000011111101101010100010001000010110100011" +
                        "00001000110100110001001100011001100010100010111000").getpValue(), 0.001);
        assertEquals(1.5374368445009168E-12, NistTest
                .frequencyTest("00000000000000000000000000000000000000000000000000").getpValue(), 0.001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);//2^16
            double result = NistTest.frequencyTest(temp).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed frequency test on sequence: " + temp);
            }
        }
    }

}
