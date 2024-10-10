package problem.no1to10;

import utils.Stopwatch;
import utils.prime.Prime;
import utils.property.Factors;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

public class Problem3 {
    public static final long TARGET = 600851475143L;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=3
        Stopwatch stopwatch2 = Stopwatch.start();
        System.out.println(
                largestPrimeFactorOrNotFound(TARGET)
        );
        stopwatch2.println();
    }

    private static String largestPrimeFactorOrNotFound(long operand) {
        return largestPrimeFactor(operand)
                .map(BigInteger::toString)
                .orElse("No prime factor found");
    }

    static Optional<Prime> largestPrimeFactor(long operand) {
        return primeFactors(operand)
                .max(BigInteger::compareTo);
    }

    private static Stream<Prime> primeFactors(long operand) {
        return primeFactorsAsBigIntegers(operand)
                .map(Prime::of)
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

    private static Stream<BigInteger> primeFactorsAsBigIntegers(long operand) {
        return Factors.of(operand).stream()
                .map(BigInteger::valueOf);
    }
}
