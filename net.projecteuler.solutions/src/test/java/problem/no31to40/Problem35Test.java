package problem.no31to40;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.prime.CircularPrimeChecker;
import utils.prime.Prime;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem35Test {
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 31, 37, 71,73,79,97,262151})
    void isCircularPrime(int i) {
        assertTrue(CircularPrimeChecker.isCircularPrime(toPrime(i)));
    }

    private static Prime toPrime(int i) {
        return Prime.of(BigInteger.valueOf(i)).orElseThrow();
    }
}