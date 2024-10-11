package problem.no21to30;

import utils.data.Range;

import java.math.BigInteger;

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
        long maxProduct = 0;
        int max = 0;
        for (int b = bRange.start; b <= bRange.end; b++) {
            if (isPrime(b)) {
                for (int a = aRange.start; a <= aRange.end; a++) {
                    int n = getN(a, b);
                    if (n > max) {
                        max = n;
                        maxProduct = (long) a * b;
                    }
                }
            }
        }
        return maxProduct;
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
}
