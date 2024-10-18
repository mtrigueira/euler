package problem.no41to50;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem50 {
    public static void main(String[] args) {
        problem("Consecutive prime sum");
        solution(
                largestConsecutivePrimeSumBelow(1_000_000)
                        .map(Prime::toString)
                        .orElse("Not found")
        );
    }

    static Optional<Prime> largestConsecutivePrimeSumBelow(int i) {
        List<Prime> primes = PrimeSequence.fromFirst().stream()
                .takeWhile(a -> a.longValueExact() < i)
                .toList();

        return IntStream.range(0, primes.size()).boxed().flatMap(j -> {
            final BigInteger[] sum = {ZERO};
            return IntStream.range(j, primes.size())
                    .mapToObj(k -> {
                        Prime p = primes.get(k);
                        sum[0] = sum[0].add(p);
                        return new Ugly(k - j, p, sum[0]);
                    })
                    .takeWhile(u -> !(u.sum.longValueExact() > i))
                    .filter(u -> PrimeChecker.isPrime(u.sum));
        }).reduce((L, R) -> L.delta > R.delta ? L : R)
                    .flatMap(a->Prime.of(a.sum));
    }

    record Ugly(int delta, Prime p, BigInteger sum) {
    }
}
