package testmd;

import md.MdTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ThreeTest {
    @Test
    public void testThree() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt(65533) + 4);//2^16
            assertEquals(TestUtils.impericalThreeFromThree(temp, "01", "011", "001"),
                    MdTest.three(temp), 0.001);
        }
    }

}
