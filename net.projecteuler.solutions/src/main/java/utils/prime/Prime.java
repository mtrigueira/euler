package utils.prime;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public class Prime extends BigInteger {
    public static SortedSet<Integer> primes = primeFactorBuilder(9999);

    public static Optional<Prime> of(BigInteger i) {
        return PrimeChecker.isPrime(i) ? Optional.of(new Prime(i.toByteArray())) : Optional.empty();
    }

    public static Optional<Prime> of(String s) {
        BigInteger i = new BigInteger(s);
        return PrimeChecker.isPrime(i) ? Optional.of(new Prime(i.toByteArray())) : Optional.empty();
    }

    public static SortedSet<Integer> eratosthenesSieve(int n) {
        if (n < 2) return new TreeSet<>();
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);

        int i = 3;
        while (i < n) {
            if (sieve[i]) {
                for (int j = i * 2; j < n; j += i)
                    sieve[j] = false;
            }
            i += 2;
        }

        SortedSet<Integer> primes = new TreeSet<>();
        primes.add(2);
        for (int j = 3; j < n; j += 2)
            if (sieve[j])
                primes.add(j);

        return primes;
    }

    public static SortedSet<Integer> primeFactorBuilder(int n) {
        if (n < 2) return new TreeSet<>();
        int[] sieve = new int[n];
        Arrays.fill(sieve, 0);
        int last = 0;
        sieve[last] = 2;
        last++;
        sieve[last] = 3;

        int i = sieve[last];
        while (i < n) {
            i++;
            boolean notPrime = false;
            for (int j = 0; j <= last; j++)
                if (i % sieve[j] == 0) {
                    notPrime = true;
                    break;
                }
            if (!notPrime) {
                last++;
                sieve[last] = i;
            }
        }

        SortedSet<Integer> primes = new TreeSet<>();
        for (int j = 0; j <= last; j++)
            primes.add(sieve[j]);

        return primes;
    }

    private Prime(byte[] val) {
        super(val);
    }
}
