package testmd;


import md.MdTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class FourTest {
    @Test
    public void testFour() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            String temp = Integer.toBinaryString(r.nextInt(65533) + 4);//2^16
            assertEquals(TestUtils.impericalTwoFromThree(temp, "01", "010", "000"),
                    MdTest.four(temp), 0.001);
        }

    }

}
