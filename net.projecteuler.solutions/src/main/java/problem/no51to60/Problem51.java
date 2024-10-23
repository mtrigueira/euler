package problem.no51to60;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem51 {
    static int minPrime = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=51
        problem("Prime digit replacements");
        solution(smallestPrime(8));
    }

    static Prime smallestPrime(int familySize) {
        return PrimeSequence.fromFirst().stream()
                .dropWhile(i -> replacementPrimeCount(i, familySize) == 0)
                .findFirst()
                .map(p -> replacementPrimeCount(p, familySize))
                .map(Object::toString)
                .flatMap(Prime::of)
                .orElseThrow();
    }

    private static int replacementPrimeCount(Prime p, int familySize) {
        return replacementPrimeCount(p.toString(), 1, familySize);
    }

    private static int replacementPrimeCount(String in, int stars, int familySize) {
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '*') continue;
            String s = in.substring(0, i) + "*" + in.substring(i + 1);
            if (replacementPrimeCount(s, familySize) == familySize)
                return minPrime;
            int primeOrZero = replacementPrimeCount(s, stars + 1, familySize);
            if (primeOrZero != 0)
                return primeOrZero;
        }

        return 0;
    }

    static int replacementPrimeCount(String in, int familySize) {
        int count = 0;
        int localMin = Integer.MAX_VALUE;

        for (int i = in.charAt(0) == '*' ? 1 : 0; i <= 9; i++)
            if (PrimeChecker.isPrime(new BigInteger(in.replace('*', (char) (i + 48))))) {
                int j = new BigInteger(in.replace('*', (char) (i + 48))).intValueExact();
                if (j < localMin)
                    localMin = j;
                count++;
            }

        if (count >= familySize)
            if (localMin < minPrime)
                minPrime = localMin;
        return count;
    }
}
