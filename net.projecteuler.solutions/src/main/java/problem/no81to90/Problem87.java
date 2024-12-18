package problem.no81to90;

import utils.prime.Prime;

import java.util.HashSet;
import java.util.Set;

import static problem.Solution.problem;

public class Problem87 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=
        problem("Prime power triples", () ->
                countPrimePowerTriplesBelow(50_000_000));
    }

    static int countPrimePowerTriplesBelow(int limit) {
        int squares = (int) Math.pow(limit, 1 / 2.0);
        int[][] raised = new int[squares][5];
        int[] primes = Prime.primeFactorBuilder(squares).stream().mapToInt(x -> x).toArray();
        Set<Integer> uniques = new HashSet<>();

        for (int pow = 2; pow <= 4; pow++)
            for (int i = 0; i < primes.length; i++) {
                double d = Math.pow(primes[i], pow);
                raised[i][pow] = d > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) d;
            }

        for (int k = 0; k < primes.length; k++) {
            if (raised[k][4] > limit) break;
            for (int j = 0; j < primes.length; j++) {
                long part = raised[k][4] + raised[j][3];
                if (part >= limit) break;
                for (int i = 0; i < primes.length; i++) {
                    if (part + raised[i][2] >= limit) break;
                    uniques.add((int)(part+raised[i][2]));
                }
            }
        }
        return uniques.size();
    }

    private Problem87() {
    }
}
