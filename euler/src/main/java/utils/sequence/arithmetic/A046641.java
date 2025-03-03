package utils.sequence.arithmetic;

import java.math.BigInteger;

public class A046641 {
    public static int a(BigInteger n) {
        int m = 1;

        while (A000041.a(m).mod(n).signum() != 0)
            m++;

        return m;
    }

    private A046641() {}
}
