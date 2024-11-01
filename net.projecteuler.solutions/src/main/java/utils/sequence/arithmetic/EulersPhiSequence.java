package utils.sequence.arithmetic;

import utils.SimpleFraction;
import utils.property.Factors;

import java.math.BigInteger;
import java.util.Set;

import static utils.SimpleFraction.ONE;
import static utils.property.Factors.countRelativePrimes;

public class EulersPhiSequence extends ArithmeticSequence<Integer> {
    private int i = 2;

    static int phiEulersProductFormula(int n) {
        Set<BigInteger> factors = Factors.primeFactors(n);
        return phiEulersProductFormula(n, factors);
    }

    static int phiEulersProductFormula(int n, Set<BigInteger> factors) {
        if (factors.isEmpty()) return n - 1;
        return factors.stream()
                .map(p -> ONE.subtract(ONE.divide(SimpleFraction.of(p))))
                .reduce(SimpleFraction::multiply)
                .map(bd -> bd.multiply(SimpleFraction.of(n)).toBigIntegerExact().intValueExact())
                .orElse(1);
    }

    public static int forGivenFactors(int n, Set<BigInteger> factors) {
        return phiEulersProductFormula(n,factors);
    }

    static int phiBruteForce(int n) {
        return countRelativePrimes(n);
    }

    @Override
    public Integer next() {
        return phiEulersProductFormula(i++);
    }
}
