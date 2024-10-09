package problem.no31to40.problem35;

import utils.operator.BigComparisonOperator;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static utils.data.DigitNumber.toByteArray;
import static utils.data.DigitNumber.toLong;

public class CircularPrimes {
    public static void main(String[] args) {
        int count = 0;

        for (int prime : primes)
            if (isCircularPrime(prime))
                count++;

        System.out.println(count);
    }

    private static final Set<Integer> primes = makePrimeSet();

    private static Set<Integer> makePrimeSet() {
        HashSet<Integer> set = new HashSet<>();
        PrimeSequence primeSequence = new PrimeSequence();

        for (BigInteger prime = primeSequence.next(); BigComparisonOperator.lessThan(prime, 1_000_000); prime = primeSequence.next())
            set.add(prime.intValueExact());

        return set;
    }

    static boolean isCircularPrime(int prime) {
        int digits = lengthOfDigits(prime);

        for (int i = 0; i < digits - 1; i++) {
            prime = rotate(prime);
            if (!primes.contains(prime))
                return false;
        }

        return true;
    }

    private static int lengthOfDigits(int i) {
        return (int) Math.log10(i) + 1;
    }

    private static int rotate(int prime) {
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
