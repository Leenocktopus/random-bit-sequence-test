package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class EntropyTest {

    @Test
    public void testResult() {
        assertEquals(0.261961, NistTest.entropyTest("0100110101",
                3).getpValue(), 0.0001);
        assertEquals(0.235301, NistTest.entropyTest("1100100100001111110" +
                        "110101010001000100001011010001100001000110100110001001100011001100010100010111000",
                2).getpValue(), 0.0001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4) +
                    Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);
            double result = NistTest.entropyTest(temp, r.nextInt(12) + 3).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed entropy test on sequence: " + temp);
            }
        }
    }
}


