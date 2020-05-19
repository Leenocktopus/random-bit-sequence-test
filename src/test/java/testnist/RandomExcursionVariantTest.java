package testnist;

import nist.NistTest;
import org.junit.Test;
import utils.TestResult;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class RandomExcursionVariantTest {

    @Test
    public void testResult() {
        double[] results = NistTest.randomExcursionsVariantTest("0110110101").stream()
                .mapToDouble(TestResult::getpValue).toArray();
        assertArrayEquals(new double[]{0.76643, 0.75182, 0.73409, 0.71192, 0.68309, 0.64342, 0.58388, 0.47950,
                        0.41421, 0.68309, 1.00000, 0.58388, 0.64342, 0.68309, 0.71192, 0.73409, 0.75182, 0.76643},
                results, 0.001);
    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4) +
                    Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);

            List<TestResult> results = NistTest.randomExcursionsVariantTest(temp);
            for (TestResult res : results) {
                if (res.getpValue() > 1 || res.getpValue() < 0) {
                    throw new RuntimeException("Failed random excursion variant test on sequence: " + temp);
                }
            }
        }
    }
}
