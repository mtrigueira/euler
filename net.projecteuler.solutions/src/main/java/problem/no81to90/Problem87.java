package problem.no81to90;

import utils.prime.Prime;

import static problem.Solution.problem;

public class Problem87 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=
        problem("Prime power triples", () ->
                countPrimePowerTriplesBelow(50_000_000));
    }

    static int countPrimePowerTriplesBelow(int limit) {
        int count = 0;
        int squares = (int) Math.pow(limit, 1 / 2.0);
        int[][] raised = new int[squares][5];
        int[] primes = Prime.primeFactorBuilder(squares).stream().mapToInt(x -> x).toArray();

        for (int pow = 2; pow <= 4; pow++)
            for (int i = 0; i < primes.length; i++)
                raised[i][pow] = (int) Math.pow(primes[i], pow);

        for (int k = 0; k < primes.length; k++)
            for (int j = 0; j < primes.length; j++) {
                int part = raised[k][4] + raised[j][3];
                if (part >= limit) break;
                for (int i = 0; i < primes.length; i++) {
                    if (part + raised[i][2] >= limit) break;
                    count++;
                }
            }

        return count;
    }
}
