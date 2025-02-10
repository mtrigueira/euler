package problem;

import static problem.Solution.problem;
import static utils.sequence.arithmetic.A000041.a;

public class Problem76 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=76
        problem("Counting summations", () ->
                solution(100));
    }

    static long solution(int n) {
        return a(n).longValueExact() - 1;
    }

    private Problem76() {}
}
