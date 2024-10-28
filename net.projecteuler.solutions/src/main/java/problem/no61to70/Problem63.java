package problem.no61to70;

import java.math.BigInteger;

import static problem.Solution.problem;

public class Problem63 {
    public static final int EXPONENT_LIMIT_FOUND_EMPIRICALLY = 22;
    public static final int BASE_LIMIT_FOUND_EMPIRICALLY = 10;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=63
        problem("Powerful digit counts",
        () -> powerfulDigitCounts(BASE_LIMIT_FOUND_EMPIRICALLY, EXPONENT_LIMIT_FOUND_EMPIRICALLY));
    }

    static int powerfulDigitCounts(int baseLimit, int exponentLimit) {
        int count = 0;

        for (int i = 1; i < baseLimit; i++)
            for (int j = 1; j < exponentLimit; j++)
                if (isExponentEqualToDigitLength(i, j))
                    count++;

        return count;
    }

    private static boolean isExponentEqualToDigitLength(int i, int j) {
        return digitLengthOfExponent(i, j) == j;
    }

    private static int digitLengthOfExponent(int i, int j) {
        return exponent(i, j).toString().length();
    }

    private static BigInteger exponent(int i, int j) {
        return BigInteger.valueOf(i).pow(j);
    }
}
