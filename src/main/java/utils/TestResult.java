package utils;

public class TestResult {
    private double pValue;
    private boolean isSequenceRandom;

    public TestResult(double pValue, boolean result) {
        this.pValue = pValue;
        this.isSequenceRandom = result;
    }

    public double getpValue() {
        return pValue;
    }

    public boolean isSequenceRandom() {
        return isSequenceRandom;
    }

    @Override
    public String toString() {
        return "{p_value: " + this.pValue + ", random: " + this.isSequenceRandom + " }";
    }
}
