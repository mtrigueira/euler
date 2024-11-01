package problem.no61to70;

import utils.prime.Prime;
import utils.sequence.Sequence;
import utils.sequence.arithmetic.EulersPhiSequence;
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
        return maximumTotientPrimeProduct(n);
    }

    static int maximumTotientPrimeProduct(int n) {
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

    static int maximumTotientBruteForce(int n) {
        Sequence<Integer> phi = new EulersPhiSequence();
        double max = 1;
        int maxI = 0;

        for (int i = 2; i < n; i++) {
            double ratio = (double) i / phi.next();
            if(ratio>max){
                max = ratio;
                maxI = i;
            }
        }

        return maxI;
    }
}
