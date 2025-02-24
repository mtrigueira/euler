package utils.sequence.arithmetic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BigIntegerConstants.big;

class A046641Test {
    static AtomicInteger n = new AtomicInteger(1);

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 11, 4, 9, 5, 11, 14, 9, 6, 21, 28, 10, 7, 15, 54, 21, 20, 58, 10, 8, 32, 21, 24, 28,
            14, 11, 26, 9, 44, 66, 16, 94, 18, 21, 86, 47, 129, 66, 35, 10, 27, 15, 14, 75, 56, 70, 19, 74, 178, 62, 52,
            340, 18, 11, 20, 26, 54, 124, 115, 101, 24, 66, 84, 21, 47, 94, 32, 19})
    void a046641(int expected) {
        assertEquals(expected, A046641.a(big(n.getAndIncrement())));
    }
}