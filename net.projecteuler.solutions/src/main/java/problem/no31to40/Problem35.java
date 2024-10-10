package problem.no31to40;

import utils.prime.CircularPrimeChecker;
import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem35 {
    public static final Set<Prime> primes = makePrimeSet();

    public static void main(String[] args) {
        int count = 0;

        for (Prime prime : primes)
            if (CircularPrimeChecker.isCircularPrime(prime))
                count++;

        System.out.println(count);
    }

    private static Set<Prime> makePrimeSet() {
        HashSet<Prime> set = new HashSet<>();
        PrimeSequence primeSequence = PrimeSequence.fromFirst();
        BigInteger limit = BigInteger.valueOf(1_000_000);

        for (Prime prime = primeSequence.next(); prime.compareTo(limit) < 0; prime = primeSequence.next())
            set.add(prime);

        return set;
    }
}
