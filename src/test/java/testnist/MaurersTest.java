package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MaurersTest {

    @Test
    public void testResult() {
        assertEquals(0.767189, NistTest.maurersTest("01011010011101010111", 2, 4).getpValue(), 0.001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4) + Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);
            int blockSize = r.nextInt(temp.length() / 10 - 2) + 2;
            int blocks = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (blockSize * j > temp.length() / 2) {
                    blocks = j - 1;
                    break;
                }
            }
            double result = NistTest.maurersTest(temp, blockSize, r.nextInt(blocks - 2) + 2).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed maurer's test on sequence: " + temp);
            }
        }
    }
}
