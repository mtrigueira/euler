package utils.prime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CircularPrimeCheckerTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113, 131, 197, 199, 311, 337, 373, 393919,
            719, 733, 919, 971, 991, 1193, 919393, 1931, 3119, 3779, 7793, 7937, 9311, 9377, 11939, 933199, 19391,
            19937, 939193, 939391, 37199, 39119, 319993, 193939, 199933, 331999, 71993, 993319, 999331, 91193, 93719,
            93911, 99371, 391939})
    void isCircularPrime(int i) {
        assertTrue(CircularPrimeChecker.isCircularPrime(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {19, 23, 29, 41, 43, 47, 53, 59, 61, 67, 83, 89, 101})
    void isNotCircularPrime(int i) {
        assertFalse(CircularPrimeChecker.isCircularPrime(i));
    }
}