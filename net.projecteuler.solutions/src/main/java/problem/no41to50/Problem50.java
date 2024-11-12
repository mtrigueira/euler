package problem.no41to50;

import utils.prime.Prime;
import utils.prime.PrimeChecker;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static problem.Solution.problem;

public class Problem50 {
     private Problem50() {
     }
    public static void main(String[] args) {
        problem("Consecutive prime sum",
        () -> 
                largestConsecutivePrimeSumBelow(1_000_000)
                        .map(Object::toString)
                        .orElse("Not found")
        );
    }

    static Optional<Long> largestConsecutivePrimeSumBelow(int i) {
        List<Integer> primes = Prime.eratosthenesSieve(i);

        return IntStream.range(0, primes.size()).boxed().flatMap(j -> {
            final long[] sum = {0};
            return IntStream.range(j, primes.size())
                    .mapToObj(k -> {
                        int p = primes.get(k);
                        sum[0] = sum[0] + p;
                        return new Ugly(k - j, p, sum[0]);
                    })
                    .takeWhile(u -> !(u.sum > i))
                    .filter(u -> PrimeChecker.isPrime(u.sum));
        }).reduce((L, R) -> L.delta > R.delta ? L : R)
                    .map(a->a.sum);
    }

    record Ugly(int delta, long prime, long sum) {
    }
}
