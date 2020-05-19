package utils;


public class Validator {

    public static void validate(String sequence) {
        if (sequence.length() < 3) {
            throw new IllegalArgumentException("Illegal sequence length ( <3): " + sequence.length());
        } else if (!sequence.matches("[01]+")) {
            throw new IllegalArgumentException("Sequence should contain only ones (1) and zeroes (0).");
        }
    }

    public static void validate(String sequence, int blockSize) {
        validate(sequence);
        if (sequence.length() < blockSize || blockSize < 2) {
            throw new IllegalArgumentException("Illegal block size ( > sequence || < 2): " + blockSize);
        }

    }

    public static void validate(String sequence, int blockSize, String template) {
        validate(sequence, blockSize);
        if (template.length() > blockSize || template.length() < 2) {
            throw new IllegalArgumentException("Illegal template length ( > block || < 2): " + template.length());
        } else if (!template.matches("[01]+")) {
            throw new IllegalArgumentException("Template should contain only ones (1) and zeroes (0).");
        }
    }

    public static void validateBinaryMatrix(String sequence, int matrixSize) {
        validate(sequence);
        if (sequence.length() < matrixSize || matrixSize < 2 || sequence.length() < matrixSize * matrixSize) {
            throw new IllegalArgumentException("Illegal matrix size ( <2 || > sequence / matrixSize): " + matrixSize);
        }
    }

    public static void validateMaurers(String sequence, int blockSize, int blocksInInitSegment) {
        validate(sequence);

        if (blockSize < 2 || blockSize > sequence.length() / 10 || blockSize > 16) {
            throw new IllegalArgumentException("Illegal block size ( < 2 || > sequence / 10 || > 16): " + blockSize);
        } else if (blocksInInitSegment * blockSize > sequence.length() / 2 || blocksInInitSegment < 1) {
            throw new IllegalArgumentException("Illegal init segment size ( 0 < || > sequence / 2)");
        }

    }

    public static void validateSerial(String sequence, int blockSize) {
        validate(sequence);
        if (sequence.length() < blockSize || blockSize < 3 || blockSize > 15) {
            throw new IllegalArgumentException("Illegal block size ( < 3 || > 15): " + blockSize);
        }
    }

    public static void validateEntropy(String sequence, int blockSize) {
        validate(sequence);
        if (sequence.length() < blockSize || blockSize < 2 || blockSize > 14) {
            throw new IllegalArgumentException("Illegal block size ( < 2 || > 14): " + blockSize);
        }
    }

}
