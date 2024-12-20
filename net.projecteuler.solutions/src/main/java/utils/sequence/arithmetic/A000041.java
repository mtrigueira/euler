package utils.sequence.arithmetic;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class A000041 {
    public static final int GROW_ARRAY_BY = 100;
    private static int maxN = 0;
    private static BigInteger[] A = {ONE};

    public static BigInteger a(int n) {
        if (n > maxN) {
            if (n + 1 > A.length) {
                BigInteger[] p = new BigInteger[n + GROW_ARRAY_BY];
                System.arraycopy(A, 0, p, 0, A.length);
                A = p;
            }
        }
        for (int i = maxN + 1; i <= n; i++) {
            A[i] = ZERO;
            boolean isRed = true;
            int plusPhase = 0;
            int red = 1;
            int blue = 1;
            int j = 0;
            for (; ; ) {
                if (isRed) {
                    j += red;
                    red += 2;
                } else {
                    j += blue;
                    blue++;
                }
                if (j > i)
                    break;

                if (plusPhase / 2 % 2 == 0)
                    A[i] = A[i].add(A[i - j]);
                else
                    A[i] = A[i].subtract(A[i - j]);

                isRed = !isRed;
                plusPhase++;
            }
        }
        if (n > maxN)
            maxN = n;

        return A[n];
    }

    private A000041() {
    }
}
