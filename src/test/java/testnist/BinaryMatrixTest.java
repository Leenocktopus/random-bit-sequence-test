package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BinaryMatrixTest {


    @Test
    public void testBinaryMatrix() {
        assertEquals(0.741948, NistTest.binaryMatrixRankTest(
                "01011001001010101101", 3).getpValue(), 0.0001);
        assertEquals(0.001526, NistTest.binaryMatrixRankTest(
                "11111111111111111111", 3).getpValue(), 0.0001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);//2^16
            int maxSize = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (Math.pow(j, 2) > temp.length()) {
                    maxSize = j - 1;
                    break;
                }
            }
            double result = NistTest.binaryMatrixRankTest(temp, r.nextInt(maxSize - 2) + 2).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed binary matrix test on sequence: " + temp);
            }
        }
    }
}
