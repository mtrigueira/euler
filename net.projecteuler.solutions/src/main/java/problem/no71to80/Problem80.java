package problem.no71to80;

import java.math.BigDecimal;
import java.math.MathContext;

import static problem.Solution.problem;

public class Problem80 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=80
        problem("Square root digital expansion", Problem80::solution);
    }

    private static long solution() {
        long total = 0;

        for (int i = 1; i <= 100; i++)
            total += sumOfFirst100DigitsOfRoot(i);

        return total;
    }

    static long sumOfFirst100DigitsOfRoot(int n) {
        if (isSquare(n))
            return 0;
        int sum = 0;
        BigDecimal d = new BigDecimal(n).sqrt(new MathContext(1010));
        String s = d.toString();
        s = s.charAt(0) + s.substring(2);

        for (int i = 0; i < 100; i++)
            sum += Integer.parseInt(s.substring(i, i + 1));

        return sum;
    }

    private static boolean isSquare(int d) {
        return Math.sqrt(d) % 1 == 0;
    }

    private Problem80() {
    }
}
