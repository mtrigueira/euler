package problem.no61to70;

import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static problem.Solution.problem;

public class Problem69 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=69
        problem("Totient maximum", () ->
                maximumTotient(1_000_000));
    }

    static int maximumTotient(int n) {
        PrimeSequence primes = PrimeSequence.fromFirst();
        BigInteger p = ONE;
        BigInteger nextP = p;
        while (nextP.compareTo(BigInteger.valueOf(n)) < 0) {
            p = nextP;
            Prime next = primes.next();
            nextP = next.multiply(p);
        }

        return p.intValueExact();
    }

    private Problem69() {
    }
}
