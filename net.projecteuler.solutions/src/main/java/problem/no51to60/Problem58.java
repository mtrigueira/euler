package problem.no51to60;

import utils.data.Layer;
import utils.prime.PrimeChecker;

import java.math.BigInteger;
import java.util.List;

import static problem.Solution.problem;

public class Problem58 {
     private Problem58() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=58
        problem("Spiral primes",
        () -> countOfPrimeDiagonalsInAGridOfNLayers(10));
    }

    static long countOfPrimeDiagonalsInAGridOfNLayers(int percent) {
        long primeCount = 0L;
        long cornerCount = 1L;
        for (int i = 2; ; i++) {
            Layer layer = Layer.of(i);
            List<BigInteger> corners = layer.corners();

            cornerCount += corners.size();
            primeCount += corners.stream().filter(PrimeChecker::isPrime).count();
            long ratio = primeCount * 100 / cornerCount;

            if(ratio < percent) return layer.lengthOfSide().longValueExact();
        }
    }
}
