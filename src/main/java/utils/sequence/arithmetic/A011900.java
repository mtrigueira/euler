package utils.sequence.arithmetic;

public class A011900 {
    private long aMinus1 = 3;
    private long aMinus2 = 1;

    public long next() {
        long a = 6*aMinus1-aMinus2-2;
        aMinus2 = aMinus1;
        aMinus1 = a;

        return a;
    }
}
