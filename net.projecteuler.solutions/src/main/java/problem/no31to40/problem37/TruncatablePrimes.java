package problem.no31to40.problem37;

import utils.prime.Prime;
import utils.prime.TruncatablePrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

public class TruncatablePrimes {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=37
        System.out.println(sumOfPrimesTruncatableInBothDirections());
    }

    private static long sumOfPrimesTruncatableInBothDirections() {
        long sum = 0;
        PrimeSequence primes = PrimeSequence.from(11);
        Prime prime = primes.next();

        for (int count = 0; count < 11; prime = primes.next())
            if (TruncatablePrimeChecker.isTruncatablePrimeBothDirections(prime)) {
                sum += prime.longValueExact();
                count++;
            }

        return sum;
    }
}
