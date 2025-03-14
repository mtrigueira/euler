package problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem12Test {
    @ParameterizedTest(name = "countFactors({0}) = {1}")
    @CsvSource({"0,0", "1,1", "3,2", "6,4", "10,4", "15,4", "21,4", "28,6", "36,9"})
    void countFactors0(int operand, int expected) {
        assertEqualsCount(expected, operand);
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
        assertEquals(count, Problem12.triangularNumber(numberOfDivisors));
    }

    private static void assertEqualsCount(int expected, int candidate) {
        assertEquals(expected, Problem12.countFactors(candidate));
    }
}