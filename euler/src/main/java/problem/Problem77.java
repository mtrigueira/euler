package problem;

import utils.prime.Prime;

import java.util.Comparator;
import java.util.List;

import static problem.Solution.problem;

public class Problem77 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=77
        problem("Prime summations", Problem77::firstNumberWithOver5000WaysOfWritingAsASumOfPrimes);
    }

    static int firstNumberWithOver5000WaysOfWritingAsASumOfPrimes() {
        int i = 1;

        while (numberOfWaysOfWritingAsASumOfPrimes(i) <= 5000)
            i++;

        return i;
    }

    private static int numberOfWaysOfWritingAsASumOfPrimes(int n, int max, List<Integer> inPrimes) {
        List<Integer> primes = inPrimes.stream()
                .filter(a -> a <= Math.min(n, max))
                .sorted(Comparator.reverseOrder()).toList();
        int count = 0;

        for (int i : primes) {
            int delta = n - i;
            if (delta > 0)
                count += numberOfWaysOfWritingAsASumOfPrimes(delta, i, primes);
            else // (delta == 0)
                count++;
        }

        return count;
    }

    static int numberOfWaysOfWritingAsASumOfPrimes(int i) {
        List<Integer> primes = Prime.primes.stream()
                .filter(a -> a <= i)
                .sorted(Comparator.reverseOrder()).toList();
        return numberOfWaysOfWritingAsASumOfPrimes(i, i, primes);
    }

    private Problem77() {}
}
