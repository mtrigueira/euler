package problem.no61to70;

import utils.prime.Prime;
import utils.sequence.arithmetic.EulersPhiSequence;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static problem.Solution.problem;

public class Problem70 {
    private Problem70() {}

    public static void main(String[] args) {
        // https://projecteuler.net/problem=70
        problem("Totient permutations", () ->
                minimumPermutationRatioN((int) Math.pow(10, 7)));
    }

    private static int minimumPermutationRatioN(int lessThan) {
        PrimeSequence seq = PrimeSequence.fromFirst();
        List<BigInteger> primes = new ArrayList<>();
        Prime next = seq.next();
        while (next.intValueExact() < (int) (Math.pow(10, Math.ceil(Math.log10(lessThan) / 2)))) {
            primes.add(next);
            next = seq.next();
        }

        int maxDigits = primes.get(primes.size() - 1).toString().length();
        primes = primes.stream().filter(p -> p.toString().length() == maxDigits).toList();

        int foundPhi = 1;
        int foundN = Integer.MAX_VALUE;

        for (BigInteger i : primes) {
            for (BigInteger j : primes) {
                if (i.compareTo(j) >= 0) continue;
                BigInteger product = i.multiply(j);
                if (product.longValueExact() > lessThan) continue;
                int n = product.intValueExact();

                int phi = EulersPhiSequence.forGivenFactors(n, Set.of(i, j));
                if (isPermutation(n, phi))
                    if (lessThan(n, phi, foundN, foundPhi)) {
                        foundPhi = phi;
                        foundN = n;
                    }
            }
        }
        return foundN;
    }

    private static boolean lessThan(int n, int phi, int foundN, int foundPhi) {
        return BigInteger.valueOf(n).multiply(BigInteger.valueOf(foundPhi)).compareTo(BigInteger.valueOf(foundN).multiply(BigInteger.valueOf(phi))) < 0;
    }

    private static boolean isPermutation(int i, int phi) {
        return sorted(String.valueOf(i)).equals(sorted(String.valueOf(phi)));
    }

    private static String sorted(String permutation) {
        return permutation.chars().sorted().mapToObj(c -> (char) c + "").reduce("", (a, b) -> a + b);
    }
}
