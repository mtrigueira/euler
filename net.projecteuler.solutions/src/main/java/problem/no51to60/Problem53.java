package problem.no51to60;

import utils.operator.Factorial;

import java.math.BigInteger;

import static problem.Solution.problem;
import static utils.operator.BigComparisonOperator.greaterThan;

public class Problem53 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=53
        problem("Combinatoric selections",
                () -> combinatoricSelections(100));
    }

    static int combinatoricSelections(int until) {
        int count = 0;
        for (int n = 1; n <= until; n++) {
            for (int r = 1; r <= n; r++) {
                if (greaterThan(combinatoricSelection(n, r), 1_000_000))
                    count++;
            }
        }
        return count;
    }

    private static BigInteger combinatoricSelection(int n, int r) {
        return combinatoricSelection(BigInteger.valueOf(n), BigInteger.valueOf(r));
    }

    private static BigInteger combinatoricSelection(BigInteger n, BigInteger r) {
        return Factorial.ofBig(n).divide(Factorial.ofBig(r).multiply(Factorial.ofBig(n.subtract(r))));
    }

    private Problem53() {
    }
}
