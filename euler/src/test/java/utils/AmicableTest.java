package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AmicableTest {
    @ParameterizedTest
    @ValueSource(ints = {220, 284, 1184, 1210, 2620, 2924})
    void hasAmicable(int a) {
        assertTrue(new Amicable(2924).hasAmicable(a));
    }

    @ParameterizedTest
    @ValueSource(ints = {221, 285, 1185, 1211, 2621, 2923})
    void hasNoAmicable(int a) {
        assertFalse(new Amicable(2924).hasAmicable(a));
    }
}