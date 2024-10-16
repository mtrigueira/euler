package problem.no51to60;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Promlem51 {
    static int minPrime = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=51
        problem("Prime digit replacements");
        solution(smallestPrime());
    }

    private static Prime smallestPrime() {
        PrimeSequence.fromFirst().stream()
                .dropWhile(i -> replacementPrimeCount(i) == 0)
                .findFirst();
        return Prime.of(Integer.toString(minPrime)).orElseThrow();
    }

    private static int replacementPrimeCount(Prime p) {
        return replacementPrimeCount(p.toString(), 1);
    }

    private static int replacementPrimeCount(String in, int stars) {
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '*') continue;
            String s = in.substring(0, i) + "*" + in.substring(i + 1);
            if (replacementPrimeCount(s) == 8)
                return minPrime;
            int primeOrZero = replacementPrimeCount(s, stars + 1);
            if (primeOrZero != 0)
                return primeOrZero;
        }

        return 0;
    }

    static int replacementPrimeCount(String in) {
        int count = 0;
        int localMin = Integer.MAX_VALUE;

        for (int i = in.charAt(0) == '*' ? 1 : 0; i <= 9; i++)
            if (PrimeChecker.isPrime(new BigInteger(in.replace('*', (char) (i + 48))))) {
                int j = new BigInteger(in.replace('*', (char) (i + 48))).intValueExact();
                if (j < localMin)
                    localMin = j;
                count++;
            }

        if (count >= 8)
            if (localMin < minPrime)
                minPrime = localMin;
        return count;
    }
}
