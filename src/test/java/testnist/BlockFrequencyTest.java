package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BlockFrequencyTest {


    @Test
    public void testResult() {
        assertEquals(0.801252,
                NistTest.blockFrequencyTest("0110011010", 3).getpValue(), 0.001);
        assertEquals(0.706438,
                NistTest.blockFrequencyTest("11001001000011111101101010100010001000010110100011" +
                        "00001000110100110001001100011001100010100010111000", 10).getpValue(), 0.001);
    }


    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);//2^16
            double result = NistTest.blockFrequencyTest(temp, r.nextInt(temp.length() - 2) + 2).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed block frequency test on sequence: " + temp);
            }
        }
    }

}
