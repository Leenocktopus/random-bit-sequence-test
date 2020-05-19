package utiltest;

import org.junit.Test;
import utils.FunctionUtils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FunctionUtilsTest {

    @Test
    public void testOnesInBlock() {
        assertEquals(0, FunctionUtils.getOnesInBlock("000000000"));
        assertEquals(6, FunctionUtils.getOnesInBlock("011100111"));
        assertEquals(0, FunctionUtils.getOnesInBlock(""));
    }

    @Test
    public void testErfc() {
        assertEquals(1, FunctionUtils.erfc(0), 0.001);
        assertEquals(0.000127, FunctionUtils.erfc(2.71), 0.001);
        assertEquals(1.571616, FunctionUtils.erfc(-0.56), 0.001);
    }

    @Test
    public void testCumNormalDistribution() {
        assertEquals(0.0003, FunctionUtils.cumNormalDistribution(-3.41), 0.001);
        assertEquals(0.8643, FunctionUtils.cumNormalDistribution(1.1), 0.001);
    }

    @Test
    public void testDFT() {
        double[] input = new double[]{1, -1, -1, 1, -1, 1, -1, -1, 1, 1};
        assertArrayEquals(new double[]{0, 2, 4.47214, 2, 4.47214, 2, 4.47214, 2, 4.47214, 2},
                FunctionUtils.dft(input, new double[input.length]), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDFTIllegalArgument() {
        FunctionUtils.dft(new double[]{}, new double[]{});
    }

    @Test
    public void testBerlekampMassey() {
        assertEquals(4, FunctionUtils.berlekampMassey("1101011110001"));
        assertEquals(1, FunctionUtils.berlekampMassey("1111111111"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBerlekampMasseyIllegalArgument() {
        FunctionUtils.berlekampMassey("");
    }

    @Test
    public void testGetExcursions() {
        assertArrayEquals(new int[]{0, -1, 0, -1, 0, 1, 0, -1, -2, -3, -4, 0},
                FunctionUtils.getExcursions("0101100000"));
        assertArrayEquals(new int[]{0, 0},
                FunctionUtils.getExcursions(""));
    }
}
