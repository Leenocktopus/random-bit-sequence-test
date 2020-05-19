package md;


import utils.Validator;

public abstract class MdStatistic {

    public double performTest(String sequence) {
        Validator.validate(sequence);
        return test(sequence);
    }

    protected abstract double test(String sequence);
}
