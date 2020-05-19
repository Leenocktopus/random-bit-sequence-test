package utiltest;

import org.junit.Test;
import utils.MatrixUtils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatrixUtilsTest {


    @Test
    public void testGetMatricesFromSequence() {
        int[][][] expected = {
                {
                        {1, 1},
                        {0, 0}
                },
                {
                        {1, 0},
                        {0, 1}
                }
        };
        assertArrayEquals(expected, MatrixUtils.getMatricesFromSequence("11001001000", 2));
        expected = new int[][][]{
                {
                        {1, 1, 0},
                        {0, 0, 0},
                        {1, 1, 1}
                },
                {
                        {1, 0, 0},
                        {0, 1, 1},
                        {0, 1, 0}
                }
        };
        assertArrayEquals(expected, MatrixUtils.getMatricesFromSequence("110000111100011010111000", 3));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMatricesWithIllegalSequence() {
        MatrixUtils.getMatricesFromSequence("", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMatricesWithIllegalMatrixSize() {
        MatrixUtils.getMatricesFromSequence("010011110101011", 10);
    }


    @Test
    public void testComputeRank() {
        int[][] input = {
                {1, 1, 0},
                {0, 1, 1},
                {0, 1, 0}
        };
        assertEquals(3, MatrixUtils.computeRank(input));
        input = new int[][]{
                {1, 1},
                {1, 1}
        };
        assertEquals(1, MatrixUtils.computeRank(input));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeRankWithIllegalMatrix() {
        MatrixUtils.computeRank(new int[][]{{}});
    }

}
