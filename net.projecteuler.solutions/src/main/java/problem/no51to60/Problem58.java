package problem.no51to60;

import utils.data.Layer;
import utils.prime.PrimeChecker;

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
        long cornerCount = Layer.of(1).corners().length;
        for (int i = 2; ; i++) {
            Layer layer = Layer.of(i);
            long[] corners = layer.corners();

            cornerCount += 4;
            if(PrimeChecker.isPrime(corners[0])) primeCount++;
            if(PrimeChecker.isPrime(corners[1])) primeCount++;
            if(PrimeChecker.isPrime(corners[2])) primeCount++;
            if(PrimeChecker.isPrime(corners[3])) primeCount++;
            long ratio = primeCount * 100 / cornerCount;

            if(ratio < percent) return layer.lengthOfSide();
        }
    }
}
