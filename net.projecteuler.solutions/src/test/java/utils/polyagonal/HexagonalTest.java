package utils.polyagonal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.polyagonal.Polygonal.HEXAGONAL;

class HexagonalTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 6, 15, 28, 45})
    void isHexagonalTest(int i) {
        BigInteger b = BigInteger.valueOf(i);
        assertTrue(HEXAGONAL.is(b));
    }
}