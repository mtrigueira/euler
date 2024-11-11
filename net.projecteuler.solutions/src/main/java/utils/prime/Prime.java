package utils.prime;

import java.math.BigInteger;
import java.util.*;
import java.util.Collections;

public class Prime extends BigInteger {
    private Prime(byte[] val) {
        super(val);
    }

    public static Optional<Prime> of(BigInteger i) {
        return PrimeChecker.isPrime(i)?Optional.of(new Prime(i.toByteArray())):Optional.empty();
    }

    public static Optional<Prime> of(String s) {
        BigInteger i = new BigInteger(s);
        return PrimeChecker.isPrime(i)?Optional.of(new Prime(i.toByteArray())):Optional.empty();
    }

    public static List<Integer> eratosthenesSieve(int n) {
        if(n < 2) return Collections.emptyList();
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);

        int i = 3;
        int count = 0;
        while (i < n) {
            if (sieve[i]) {
                for (int j = i * 2; j < n; j += i)
                    sieve[j] = false;
                count++;
            }
            i+=2;
        }

        List<Integer> primes = new ArrayList<>(count);
        primes.add(2);
        for (int j = 3; j < n; j+=2)
            if (sieve[j])
                primes.add(j);

        return primes;
    }
}
