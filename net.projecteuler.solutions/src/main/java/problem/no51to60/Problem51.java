package problem.no51to60;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static problem.Solution.problem;

public class Problem51 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=51
        problem("Prime digit replacements",
                () -> smallestPrime(8));
    }

    static int minPrime = Integer.MAX_VALUE;

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
            if (alreadyStarOrCannotBeMinima(in, i))
                continue;
            String mask = in.substring(0, i) + "*" + in.substring(i + 1);
            if (isNotDivisibleByThreeSoMayBePrime(stars))
                if (replacementPrimeCount(mask, familySize) == familySize)
                    return minPrime;

            if (replacementPrimeCount(mask, stars + 1, familySize) != 0)
                return minPrime;
        }

        return 0;
    }

    private static boolean isNotDivisibleByThreeSoMayBePrime(int stars) {
        return stars % 3 == 0;
    }

    private static boolean alreadyStarOrCannotBeMinima(String in, int i) {
        return "*3456789".indexOf(in.charAt(i)) != -1;
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

    private Problem51() {
    }
}
