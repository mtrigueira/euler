package problem.no31to40;

import utils.prime.CircularPrimeChecker;
import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

public class Problem35 {
    public static void main(String[] args) {
        int count = 0;
        PrimeSequence primeSequence = PrimeSequence.fromFirst();
        BigInteger limit = BigInteger.valueOf(1_000_000);

        for (Prime prime = primeSequence.next(); prime.compareTo(limit) < 0; prime = primeSequence.next())
            if (CircularPrimeChecker.isCircularPrime(prime))
                count++;

        System.out.println(count);
    }
}
