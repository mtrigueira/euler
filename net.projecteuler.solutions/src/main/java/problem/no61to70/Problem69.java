package problem.no61to70;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static problem.Solution.problem;

public class Problem69 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=
        problem("Totient maximum", () ->
                maximumTotient(1_000_000));
    }

    static int maximumTotient(int n) {
        findRelativePrimes(n);
        double max = 1;
        int maxI = 0;
        for (int i = 2; i < n; i++) {
            int phi = phi(i);
            double ratio = (double) i / phi;
            if(ratio>max){
                max = ratio;
                maxI = i;
            }
        }
        return maxI;
    }

    private static int phi(int n) {
        List<Integer> relativePrimes = findRelativePrimes(n);
        return relativePrimes.size();
    }

    static List<Integer> findRelativePrimes(int i) {
        List<Integer> primes = new ArrayList<>();
        for (int j = 1; j < i; j++) {
            if (BigInteger.valueOf(i).gcd(BigInteger.valueOf(j)).equals(BigInteger.ONE))  {
                primes.add(j);
            }
        }
        return primes;
    }
}
