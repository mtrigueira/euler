package problem.no71to80;

import static problem.Solution.problem;

public class Problem76 {
    private Problem76() {}

    public static void main(String[] args) {
        // https://projecteuler.net/problem=76
        problem("Counting summations", () ->
                solution(100));
    }

    static long solution(int n) {
        return A000041(n) - 1;
    }

    static int A000041(int n) {
        int[] p = new int[n + 1];
        p[0] = 1;

        for (int i = 1; i <= n; i++) {
            boolean isRed = true;
            int plusPhase = 0;
            int red = 1;
            int blue = 1;
            int j = 0;
            for (;;) {
                if (isRed) {
                    j += red;
                    red += 2;
                } else {
                    j += blue;
                    blue++;
                }
                if (j > i) break;

                if (plusPhase / 2 % 2 == 0)
                    p[i] += p[i - j];
                else
                    p[i] -= p[i - j];

                isRed = !isRed;
                plusPhase++;
            }
        }

        return p[n];
    }
}
