package utils.sequence.arithmetic;

import utils.property.Factors;

import java.math.BigInteger;
import java.util.Set;

import static utils.property.Factors.countRelativePrimes;

public class EulersPhiSequence extends ArithmeticSequence<Integer> {
    private int i = 2;

    static int phiEulersProductFormula(int n) {
        Set<BigInteger> factors = Factors.primeFactors(n);
        if (factors.isEmpty()) return n - 1;

        return (int) (n * factors.stream()
                .map(p -> 1.0 - 1.0 / p.doubleValue())
                .reduce((a, b) -> a * b)
                .orElse(1.0));
    }

    static int phiBruteForce(int n) {
        return countRelativePrimes(n);
    }

    @Override
    public Integer next() {
        return phiEulersProductFormula(i++);
    }
}
