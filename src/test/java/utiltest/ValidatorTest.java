package utiltest;

import md.MdTest;
import nist.NistTest;
import org.junit.Test;

public class ValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentBlockSize() {
        NistTest.blockFrequencyTest("0110011010", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentsShortSequence() {
        NistTest.frequencyTest("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentBigMatrixSize() {
        NistTest.binaryMatrixRankTest("1010010111111", 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentSmallMatrixSize() {
        NistTest.binaryMatrixRankTest("1010010111111", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentBigTemplate() {
        NistTest.nonOverlappingTemplateTest("010101111", 3, "1100");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentShortTemplate() {
        NistTest.overlappingTemplateTest("010101111", 3, "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentIncorrectTemplateValues() {
        NistTest.nonOverlappingTemplateTest("0101011001111", 3, "$ABC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentSmallMaurersBlock() {
        NistTest.maurersTest("0101001011111", 1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentBigMaurersBlock() {
        NistTest.maurersTest("0101001011111", 10, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentBigMaurersInit() {
        NistTest.maurersTest("0101001011111", 2, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentSmallMaurersInit() {
        NistTest.maurersTest("0101001011111", 2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentSerialBigBlock() {
        NistTest.serialTest("100101001111111110000001111111", 16);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentSerialSmallBlock() {
        NistTest.serialTest("100101001111111110000001111111", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentEntropyBigBlock() {
        NistTest.entropyTest("1001011110101000011111", 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentEntropySmallBlock() {
        NistTest.entropyTest("101010101111111111", 1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentMDWrongSymbols() {
        MdTest.two("abcde 0001111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentNistWrongSymbols() {
        NistTest.randomExcursionsTest("sdasdhpsaodisdlasdm;lk,sm;lm ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentMdShortSequence() {
        MdTest.one("1");
    }

}
