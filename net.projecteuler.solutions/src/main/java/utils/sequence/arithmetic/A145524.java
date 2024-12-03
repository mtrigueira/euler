package utils.sequence.arithmetic;

import static java.math.BigInteger.TEN;

public class A145524 {
    private A145524() {}

    public static int a(int n) {
        return A046641.a(TEN.pow(n-1));
    }
}
