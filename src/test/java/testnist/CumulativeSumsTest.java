package testnist;

import nist.NistTest;
import org.junit.Test;
import utils.TestResult;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class CumulativeSumsTest {
    @Test
    public void testResult() {
        double[] results = NistTest.cumulativeSumsTest("1011010111").stream()
                .mapToDouble(TestResult::getpValue).toArray();
        assertArrayEquals(new double[]{0.4116588, 0.4116588}, results, 0.001);
        results = NistTest.cumulativeSumsTest("11001001000011111101101010100010001000010110100011" +
                "00001000110100110001001100011001100010100010111000").stream()
                .mapToDouble(TestResult::getpValue).toArray();
        assertArrayEquals(new double[]{0.219194, 0.114866}, results, 0.0001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4) +
                    Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);

            List<TestResult> results = NistTest.cumulativeSumsTest(temp);

            for (TestResult res : results) {
                if (res.getpValue() > 1 || res.getpValue() < 0) {

                    throw new RuntimeException("Failed cumulative sum test on sequence: " + temp);
                }
            }
        }
    }

}
