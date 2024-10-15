package problem.no31to40;

import utils.prime.CircularPrimeChecker;
import utils.prime.Prime;
import utils.sequence.Sequence;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.function.Function;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem35 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=35
        problem("Circular primes");

        BigInteger limit = BigInteger.valueOf(1_000_000);

        solution(PrimeSequence.fromFirst().stream()
                .takeWhile(a1 -> !(a1.compareTo(limit) < 0))
                .filter(prime1 -> !CircularPrimeChecker.isCircularPrime(prime1))
                .count());
    }
}
