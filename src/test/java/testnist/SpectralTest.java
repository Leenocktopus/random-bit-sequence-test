package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SpectralTest {

    @Test
    public void testResult() {
        assertEquals(0.029523, NistTest.spectralTest("1001010011").getpValue(), 0.0001);
        assertEquals(0.646355, NistTest.spectralTest("1100100100001111110110101010001000" +
                "100001011010001100001000110100110001001100011001100010100010111000").getpValue(), 0.0001);

    }


    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);//2^16
            double result = NistTest.spectralTest(temp).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed spectral test on sequence: " + temp);
            }
        }
    }
}
