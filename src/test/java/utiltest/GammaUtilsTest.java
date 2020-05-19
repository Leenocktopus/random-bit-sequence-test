package utiltest;

import org.junit.Test;
import utils.GammaUtils;

import static org.junit.Assert.assertEquals;

public class GammaUtilsTest {


    @Test
    public void testGammaLn() {
        assertEquals(0.36787945, GammaUtils.gammaFunction(1, 1), 0.001);
        assertEquals(0.13533528, GammaUtils.gammaFunction(1, 2), 0.001);
        assertEquals(1, GammaUtils.gammaFunction(1, 0), 0.001);
        assertEquals(0.004034, GammaUtils.gammaFunction(5. / 3, 7), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentA() {
        GammaUtils.gammaFunction(-3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentXlessThanZero() {
        GammaUtils.gammaFunction(1, -2);
    }

}
