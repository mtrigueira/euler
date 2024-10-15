package problem.no41to50;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem50 {
    public static void main(String[] args) {
        problem("Consecutive prime sum");
        solution(largestConsecutivePrimeSumBelow(1_000_000).map(Prime::toString).orElse("Not found"));
    }

    static Optional<Prime> largestConsecutivePrimeSumBelow(int i) {
        List<Prime> primes = PrimeSequence.fromFirst().stream()
                .takeWhile(a -> a.longValueExact() < i)
                .toList();

        int max = 0;
        Optional<Prime> maxPrime = Optional.empty();
        for (int j = 0; j < primes.size(); j++) {
            BigInteger sum = ZERO;
            for (int k = j; k < primes.size(); k++) {
                Prime p = primes.get(k);
                sum = sum.add(p.toBigInteger());
                if (sum.longValueExact() > i)
                    break;

                if (PrimeChecker.isPrime(sum))
                    if (k - j > max) {
                        max = k - j;
                        maxPrime = Prime.of(sum);
                    }

            }
        }

        return maxPrime;
    }
}
