package problem.no31to40.problem35;

import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static utils.data.DigitNumber.toByteArray;
import static utils.data.DigitNumber.toLong;

public class CircularPrimes {
    public static void main(String[] args) {
        int count = 0;

        for (Prime prime : primes)
            if (isCircularPrime(prime))
                count++;

        System.out.println(count);
    }

    private static final Set<Prime> primes = makePrimeSet();

    private static Set<Prime> makePrimeSet() {
        HashSet<Prime> set = new HashSet<>();
        PrimeSequence primeSequence = PrimeSequence.fromFirst();
        BigInteger limit = BigInteger.valueOf(1_000_000);

        for (Prime prime = primeSequence.next(); prime.toBigInteger().compareTo(limit) < 0; prime = primeSequence.next())
            set.add(prime);

        return set;
    }

    static boolean isCircularPrime(Prime prime) {
        int primeInt = prime.toBigInteger().intValueExact();
        int digits = lengthOfDigits(primeInt);

        for (int i = 0; i < digits - 1; i++)
            if (rotate(primeInt).isEmpty())
                return false;

        return true;
    }

    private static int lengthOfDigits(int i) {
        return (int) Math.log10(i) + 1;
    }

    private static Optional<Prime> rotate(int prime) {
        return Prime.of(BigInteger.valueOf(rotate2(prime)));
    }

    private static int rotate2(int prime) {
        byte[] bytes = rotate(toByteArray(prime));
        return Math.toIntExact(toLong(bytes));
    }

    private static byte[] rotate(byte[] bytes) {
        byte first = bytes[0];
        System.arraycopy(bytes, 1, bytes, 0, bytes.length - 1);
        bytes[bytes.length - 1] = first;

        return bytes;
    }
}
