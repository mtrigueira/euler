package utils.property;

import utils.prime.PrimeChecker;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.math.BigInteger.ONE;

public class Factors {
    public static Set<Long> of(long n) {
        if (n < 1) return Collections.emptySet();

        Set<Long> s = ProperDivisors.of(n);
        s.add(n);

        return s;
    }

    public static Set<BigInteger> of(BigInteger n) {
        if (n.signum() < 1) return Collections.emptySet();

        Set<BigInteger> s = ProperDivisors.of(n);
        s.add(n);

        return s;
    }

    public static boolean isFactor(BigInteger i, BigInteger candidate) {
        return i.mod(candidate).signum() == 0;
    }

    public static boolean isFactor(long i, long candidate) {
        return i % candidate == 0;
    }

    public static List<Integer> findRelativePrimes(int i) {
        BigInteger n = BigInteger.valueOf(i);
        List<Integer> primes = new ArrayList<>();

        for (int j = 1; j < i; j++)
            if (ONE.equals(n.gcd(BigInteger.valueOf(j))))
                primes.add(j);

        return primes;
    }

    public static int countRelativePrimes(int i) {
        BigInteger n = BigInteger.valueOf(i);
        int primes = 0;

        for (int j = 1; j < i; j++)
            if (ONE.equals(n.gcd(BigInteger.valueOf(j))))
                primes++;

        return primes;
    }

    public static Set<BigInteger> primeFactors(int n) {
        return ProperDivisors.of(n).stream().map(BigInteger::valueOf).dropWhile(ONE::equals).filter(PrimeChecker::isPrime).collect(Collectors.toSet());
    }

    private Factors() {
    }
}
