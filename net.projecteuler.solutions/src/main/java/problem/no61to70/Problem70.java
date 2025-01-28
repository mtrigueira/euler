package problem.no61to70;

import utils.SimpleFraction;
import utils.prime.Prime;
import utils.sequence.arithmetic.PrimeSequence;

import java.util.ArrayList;
import java.util.List;

import static problem.Solution.problem;
import static utils.SimpleFraction.ONE;

public class Problem70 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=70
        problem("Totient permutations", () ->
                minimumPermutationRatioN((int) Math.pow(10, 7)));
    }

    private static int minimumPermutationRatioN(int lessThan) {
        PrimeSequence seq = PrimeSequence.fromFirst();
        List<Integer> primes = new ArrayList<>();

        int limit = (int) (Math.pow(10, Math.ceil(Math.log10(lessThan) / 2)));
        for (Prime next = seq.next(); next.intValueExact() < limit; next = seq.next())
            primes.add(next.intValueExact());

        int maxDigits = primes.getLast().toString().length();
        primes = primes.stream().filter(p -> p.toString().length() == maxDigits).toList();

        int foundPhi = 1;
        int foundN = Integer.MAX_VALUE;

        for (Integer i : primes) {
            for (Integer j : primes) {
                if (i.compareTo(j) >= 0)
                    continue;
                int product = i * j;
                if (product >= lessThan)
                    break;

                int phi = ONE.subtract(SimpleFraction.of(1, i)).multiply(ONE.subtract(SimpleFraction.of(1, j))).multiply(SimpleFraction.of(product)).toBigIntegerExact().intValueExact();
                if (isPermutation(product, phi))
                    if (lessThan(product, phi, foundN, foundPhi)) {
                        foundPhi = phi;
                        foundN = product;
                    }
            }
        }
        return foundN;
    }

    private static boolean lessThan(long n, long phi, long foundN, long foundPhi) {
        return n * foundPhi < foundN * phi;
    }

    private static boolean isPermutation(int left, int right) {
        int[] digits = new int[10];
        int remainder = left;
        int n = 0;
        int count = 0;
        while (remainder > 0) {
            digits[n++] = remainder % 10;
            remainder /= 10;
            count++;
        }

        remainder = right;
        while (remainder > 0) {
            boolean found = false;
            int digit = remainder % 10;
            remainder /= 10;

            for (int i = 0; i < n; i++)
                if (digits[i] == digit) {
                    digits[i] = -1;
                    found = true;
                    count--;
                    break;
                }

            if(!found)
                return false;
        }
        return true;
    }

    private Problem70() {}
}
