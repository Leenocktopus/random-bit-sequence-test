package testnist;

import nist.NistTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class LongestRunOfOnesTest {

    @Test
    public void testLongestRunOfOnes() {
        assertEquals(0.180598, NistTest.longestRunOfOnesTest("1100110000010101011011000100" +
                "11001110000000000010010011010101000100010011110101101000000011010111110011001110011011011000" +
                "10110010").getpValue(), 0.0001);
        assertEquals(0.002534, NistTest.longestRunOfOnesTest(
                "000000000000").getpValue(), 0.0001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);//2^16
            double result = NistTest.longestRunOfOnesTest(temp).getpValue();
            if (result > 1 || result < 0) {
                throw new RuntimeException("Failed longest run of ones test on sequence: " + temp);
            }
        }
    }
}
