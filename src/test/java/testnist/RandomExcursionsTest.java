package testnist;

import nist.NistTest;
import org.junit.Test;
import utils.TestResult;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class RandomExcursionsTest {

    @Test
    public void testResult() {
        double[] results = NistTest.randomExcursionsTest("0110110101").stream()
                .mapToDouble(TestResult::getpValue).toArray();
        assertArrayEquals(new double[]{0.99450, 0.98800, 0.96256, 0.96256, 0.502529, 0.14251, 0.988003, 0.99450},
                results, 0.001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4) +
                    Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);

            List<TestResult> results = NistTest.randomExcursionsTest(temp);
            for (TestResult res : results) {
                if (res.getpValue() > 1.0000 || res.getpValue() < 0) {
                    throw new RuntimeException("Failed random excursions test on sequence: " + temp);
                }
            }
        }
    }
}
