package problem.no21to30;

import utils.data.Range;
import utils.prime.PrimeChecker;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.prime.PrimeChecker.isPrime;

public class Problem27 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=27
        problem("Quadratic primes");
        solution(getMaxProduct(Range.rangeExclusiveAbs(1000), Range.rangeAbs(1000)));
    }

    private static long getMaxProduct(Range aRange, Range bRange) {
        return IntStream.rangeClosed(bRange.start, bRange.end)
                        .filter(PrimeChecker::isPrime)
                        .boxed()
                        .flatMap(b -> IntStream.range(aRange.start, aRange.end)
                                .mapToObj(a -> new Ugly(a*b, getN(a, b)))
                        ).reduce((L, R) -> (L.n > R.n) ? L : R
                        ).map(L -> L.product).orElse(0);
    }

    private static int getN(long a, long b) {
        BigInteger candidate;
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);

        for (int n = 1; ; n++) {
            BigInteger bigN = BigInteger.valueOf(n);
            candidate = bigN.pow(2).add(bigA.multiply(bigN)).add(bigB);
            if (!isPrime(candidate))
                return n - 1;
        }
    }

    record Ugly(int product, int n){}
}
