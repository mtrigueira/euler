package problem.no41to50;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem45Test {
    @ParameterizedTest
    @ValueSource(ints = {1, 6, 15, 28, 45})
    void isPentagonalTest(int i) {
        BigInteger b = BigInteger.valueOf(i);
        assertTrue(Problem45.isHexagonal(b));
    }
}