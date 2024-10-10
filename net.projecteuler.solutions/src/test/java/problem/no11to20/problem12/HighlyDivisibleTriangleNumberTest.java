package problem.no11to20.problem12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class HighlyDivisibleTriangleNumberTest {
    @ParameterizedTest
    @CsvSource({"0,0","1,1", "3,2", "6,4", "10,4", "15,4", "21,4", "28,6", "36,9"})
    void countFactors0(int operand, int count) {
        BigInteger candidate = BigInteger.valueOf(operand);
        assertEquals(count, HighlyDivisibleTriangleNumber.countFactors(candidate));
    }

    @Test
    void withOver5() {
        assertEquals(28, HighlyDivisibleTriangleNumber.withOver(5));
    }

    @Test
    void withOver6() {
        assertEquals(28, HighlyDivisibleTriangleNumber.withOver(6));
    }
}