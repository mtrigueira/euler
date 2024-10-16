package problem.no31to40;

import utils.prime.Prime;
import utils.prime.TruncatablePrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem37 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=37
        problem("Truncatable primes");
        solution(
                PrimeSequence.from(11).stream()
                        .filter(TruncatablePrimeChecker::isTruncatablePrimeBothDirections)
                        .limit(11)
                        .map(Prime::toBigInteger)
                        .reduce(ZERO, BigInteger::add)
        );
    }
}
