package problem.no31to40.problem35;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CircularPrimesTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 31, 37, 71,73,79,97})
    void isCircularPrime(int prime) {
        assertTrue(CircularPrimes.isCircularPrime(prime));
    }
}