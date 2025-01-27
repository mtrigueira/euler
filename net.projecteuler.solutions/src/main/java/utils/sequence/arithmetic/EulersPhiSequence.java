package utils.sequence.arithmetic;

import utils.SimpleFraction;
import utils.property.Factors;

import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.SimpleFraction.ONE;
import static utils.property.Factors.countRelativePrimes;

public class EulersPhiSequence extends ArithmeticSequence<Long> {
    private int i = 2;

    EulersPhiSequence() {}

    static long phiEulersProductFormula(int n) {
        Set<Integer> factors = Factors.primeFactors(n).stream().map(BigInteger::intValueExact).collect(Collectors.toSet());
        return phiEulersProductFormula(n, factors);
    }

    static long phiEulersProductFormula(int n, Set<Integer> factors) {
        if (factors.isEmpty())
            return n - 1;
        return factors.stream().map(p -> ONE.subtract(SimpleFraction.of(1, p))).reduce(SimpleFraction::multiply).map(bd -> bd.multiply(SimpleFraction.of(n)).toBigIntegerExact().intValueExact()).orElse(1);
    }

    static int phiBruteForce(int n) {
        return countRelativePrimes(n);
    }

    @Override
    public Long next() {
        return phiEulersProductFormula(i++);
    }
}
