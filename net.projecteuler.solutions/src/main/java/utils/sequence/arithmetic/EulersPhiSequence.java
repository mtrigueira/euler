package utils.sequence.arithmetic;

import utils.SimpleFraction;
import utils.property.Factors;

import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.SimpleFraction.ONE;
import static utils.property.Factors.countRelativePrimes;

public class EulersPhiSequence extends ArithmeticSequence<Long> {
    EulersPhiSequence() {}

    private int i = 2;

    static long phiEulersProductFormula(int n) {
        Set<Integer> factors = Factors.primeFactors(n).stream().map(BigInteger::intValueExact).collect(Collectors.toSet());
        return phiEulersProductFormula(n, factors);
    }

    static long phiEulersProductFormula(int n, Set<Integer> factors) {
        if (factors.isEmpty()) return n - 1;
        return factors.stream()
                .map(p -> ONE.subtract(ONE.divide(SimpleFraction.of(p))))
                .reduce(SimpleFraction::multiply)
                .map(bd -> bd.multiply(SimpleFraction.of(n)).toBigIntegerExact().intValueExact())
                .orElse(1);
    }

    public static long forGivenFactors(int n, Set<Integer> factors) {
        return phiEulersProductFormula(n,factors);
    }

    static int phiBruteForce(int n) {
        return countRelativePrimes(n);
    }

    @Override
    public Long next() {
        return phiEulersProductFormula(i++);
    }
}
