package nist;


import utils.TestResult;
import utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NistTest {
    public final static double acceptance = 0.01;

    public static TestResult frequencyTest(String sequence) {
        Validator.validate(sequence);
        double pValue = Frequency.test(sequence);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult blockFrequencyTest(String sequence, int blockSize) {
        Validator.validate(sequence, blockSize);
        double pValue = BlockFrequency.test(sequence, blockSize);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static List<TestResult> cumulativeSumsTest(String sequence) {
        Validator.validate(sequence);
        double[] pValues = CumulativeSums.test(sequence);
        return Arrays.stream(pValues)
                .mapToObj(item -> new TestResult(item, item >= acceptance))
                .collect(Collectors.toList());
    }

    public static TestResult entropyTest(String sequence, int blockSize) {
        Validator.validateEntropy(sequence, blockSize);
        double pValue = Entropy.test(sequence, blockSize);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult nonOverlappingTemplateTest(String sequence, int blockSize, String template) {
        Validator.validate(sequence, blockSize, template);
        double pValue = NonOverlappingTemplate.test(sequence, blockSize, template);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult overlappingTemplateTest(String sequence, int blockSize, String template) {
        Validator.validate(sequence, blockSize, template);
        double pValue = OverlappingTemplate.test(sequence, blockSize, template);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult binaryMatrixRankTest(String sequence, int matrixSize) {
        Validator.validateBinaryMatrix(sequence, matrixSize);
        double pValue = BinaryMatrixRank.test(sequence, matrixSize);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult maurersTest(String sequence, int blockSize, int blocksInInitSegment) {
        Validator.validateMaurers(sequence, blockSize, blocksInInitSegment);
        double pValue = Maurers.test(sequence, blockSize, blocksInInitSegment);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult linearComplexityTest(String sequence, int blockSize) {
        Validator.validate(sequence, blockSize);
        double pValue = LinearComplexity.test(sequence, blockSize);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult longestRunOfOnesTest(String sequence) {
        Validator.validate(sequence);
        double pValue = LongestRunOfOnes.test(sequence);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult spectralTest(String sequence) {
        Validator.validate(sequence);
        double pValue = Spectral.test(sequence);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static TestResult runsTest(String sequence) {
        Validator.validate(sequence);
        double pValue = Runs.test(sequence);
        return new TestResult(pValue, pValue >= acceptance);
    }

    public static List<TestResult> serialTest(String sequence, int blockSize) {
        Validator.validateSerial(sequence, blockSize);
        double[] pValues = Serial.test(sequence, blockSize);
        return Arrays.stream(pValues)
                .mapToObj(item -> new TestResult(item, item >= acceptance))
                .collect(Collectors.toList());
    }

    public static List<TestResult> randomExcursionsTest(String sequence) {
        Validator.validate(sequence);
        double[] pValues = RandomExcursions.test(sequence);
        return Arrays.stream(pValues)
                .mapToObj(item -> new TestResult(item, item >= acceptance))
                .collect(Collectors.toList());
    }

    public static List<TestResult> randomExcursionsVariantTest(String sequence) {
        Validator.validate(sequence);
        double[] pValues = RandomExcursionVariant.test(sequence);
        return Arrays.stream(pValues)
                .mapToObj(item -> new TestResult(item, item >= acceptance))
                .collect(Collectors.toList());
    }

}
