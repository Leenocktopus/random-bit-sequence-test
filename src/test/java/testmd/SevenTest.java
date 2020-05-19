package testmd;


import md.MdTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SevenTest {
    @Test
    public void testSeven() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt(65533) + 4);//2^16
            assertEquals(TestUtils.impericalThreeFromThree(temp, "01", "000", "010"),
                    MdTest.seven(temp), 0.001);
        }

    }
}
