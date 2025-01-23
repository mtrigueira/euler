package utils.sequence.arithmetic;

import java.util.Arrays;

public class A000041Fast {
    public static final int GROW_ARRAY_BY = 100;
    private static int maxN = 10;
    private static int[] A = {1, 1, 2, 3, 5, 7, 11, 15, 22, 30, 42};

    public static int a(int n, int mod) {
        if (n > maxN) {
            if (n + 1 > A.length) {
                int[] p = new int[n + GROW_ARRAY_BY];
                System.arraycopy(A, 0, p, 0, A.length);
                A = p;
            }
            for (int i = maxN + 1; i <= n; i++) {
                A[i] = 0;
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
                        A[i] = (A[i] + A[i - j]);
                    else
                        A[i] = (A[i] - A[i - j]);

                    isRed = !isRed;
                    plusPhase++;
                }
                A[i] = A[i] % mod;
            }

            maxN = n;
        }

        return A[n];
    }

    private A000041Fast() {}
}
