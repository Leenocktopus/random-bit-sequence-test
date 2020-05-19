package testnist;

import nist.NistTest;
import org.junit.Test;
import utils.TestResult;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class SerialTest {
    @Test
    public void testResult() {
        double[] results = NistTest.serialTest("0011011101", 3).stream()
                .mapToDouble(TestResult::getpValue).toArray();
        assertArrayEquals(new double[]{0.808792, 0.670320}, results, 0.0001);


    }

    @Test
    public void testRandomResult() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4) +
                    Integer.toBinaryString(r.nextInt((int) Math.pow(2, 32)) + 4);

            List<TestResult> results = NistTest.serialTest(temp, r.nextInt(13) + 3);
            for (TestResult res : results) {
                if (res.getpValue() > 1 || res.getpValue() < 0) {
                    throw new RuntimeException("Failed serial test on sequence: " + temp);
                }
            }
        }
    }


}
