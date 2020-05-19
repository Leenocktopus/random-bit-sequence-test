package md;

public class MdTest {

    public static double one(String sequence) {
        MdStatistic statistic = new One();
        return statistic.performTest(sequence);
    }

    public static double two(String sequence) {
        MdStatistic statistic = new Two();
        return statistic.performTest(sequence);
    }

    public static double three(String sequence) {
        MdStatistic statistic = new Three();
        return statistic.performTest(sequence);
    }

    public static double four(String sequence) {
        MdStatistic statistic = new Four();
        return statistic.performTest(sequence);
    }

    public static double five(String sequence) {
        MdStatistic statistic = new Five();
        return statistic.performTest(sequence);
    }

    public static double six(String sequence) {
        MdStatistic statistic = new Six();
        return statistic.performTest(sequence);
    }

    public static double seven(String sequence) {
        MdStatistic statistic = new Seven();
        return statistic.performTest(sequence);
    }

    public static double eight(String sequence) {
        MdStatistic statistic = new Eight();
        return statistic.performTest(sequence);
    }

}
