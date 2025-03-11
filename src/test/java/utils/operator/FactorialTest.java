package utils.operator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    void One() {
        assertEquals(1, Factorial.of(1));
    }

    @Test
    void Two() {
        assertEquals(2, Factorial.of(2));
    }

    @Test
    void Three() {
        assertEquals(6, Factorial.of(3));
    }

    @Test
    void Four() {
        assertEquals(24, Factorial.of(4));
    }

    @Test
    void Zero() {
        assertEquals(1, Factorial.of(0));
    }

    @Test
    void Negative() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.of(-1));
    }

    @ParameterizedTest(name = "{1}! should be {0}")
    @org.junit.jupiter.params.provider.CsvSource({
            "1, 1",
            "2, 2",
            "6, 3",
            "24, 4",
            "120, 5",
            "3628800, 10",
            "39916800, 11",
            "2432902008176640000, 20"
    })
    void factorial(long expected, int i) {
        assertEquals(expected, Factorial.of(i));
    }
}