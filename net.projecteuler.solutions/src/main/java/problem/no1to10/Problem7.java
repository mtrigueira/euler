package problem.no1to10;

import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import static problem.Solution.problem;

public class Problem7 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=7
        problem("10001st prime",
                () ->
                        prime(10001));
    }

    public static Prime prime(int n) {
        return PrimeSequence.fromFirst().stream().skip(n - 1).findFirst().orElse(null);
    }

    private Problem7() {}
}
