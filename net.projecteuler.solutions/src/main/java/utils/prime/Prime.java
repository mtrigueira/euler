package utils.prime;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);

        int i = 2;
        while (i < n) {
            if (sieve[i]) {
                for (int j = i*2; j < n; j += i)
                    sieve[j] = false;
            }
            i++;
        }

        List<Integer> primes = new ArrayList<>();
        for (int j = 2; j < n; j++)
            if (sieve[j])
                primes.add(j);

        return primes;
    }

    public BigInteger toBigInteger() {
        return this;
    }
}
