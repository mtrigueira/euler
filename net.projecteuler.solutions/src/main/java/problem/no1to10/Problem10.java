package problem.no1to10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static problem.Solution.problem;

public class Problem10 {
    private Problem10() {
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=10
        problem("Sum of primes below 2,000,000",
                () ->
                        sumOfPrimesBelow(2_000_000));
    }

    static long sumOfPrimesBelow(int i) {
        return eratosthenesSieve(i).stream()
                .takeWhile(a -> a < i)
                .mapToLong(a -> a)
                .sum();
    }

    private static List<Integer> eratosthenesSieve(int n) {
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);

        int i = 2;
        while (i < n) {
            if (sieve[i]) {
                for (int j = i*2; j < n; j += i)
                    sieve[j] = false;
            }
            i++;
        }

        List<Integer> primes = new ArrayList<>();
        for (int j = 2; j < n; j++)
            if (sieve[j])
                primes.add(j);

        return primes;
    }
}
