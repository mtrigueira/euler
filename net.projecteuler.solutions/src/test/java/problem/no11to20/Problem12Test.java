package problem.no11to20;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem12Test {
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "3,2", "6,4", "10,4", "15,4", "21,4", "28,6", "36,9"})
    void countFactors0(int operand, int count) {
        assertEqualsCount(count, operand);
    }

    @Test
    void withOver5() {
        assertEqualsTriangularNumber(28, 5);
    }

    @Test
    void withOver6() {
        assertEqualsTriangularNumber(28, 6);
    }

    @Test
    void withOver7() {
        assertEqualsTriangularNumber(36, 7);
    }

    private static void assertEqualsTriangularNumber(int count, int numberOfDivisors) {
        BigInteger b = BigInteger.valueOf(count);
        assertEquals(b, Problem12.triangularNumber(numberOfDivisors));
    }

    private static void assertEqualsCount(int count, int candidate) {
        BigInteger b = BigInteger.valueOf(candidate);
        assertEquals(count, Problem12.countFactors(b));
    }
}