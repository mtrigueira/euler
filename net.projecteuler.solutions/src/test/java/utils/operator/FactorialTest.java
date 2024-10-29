package utils.operator;

import org.junit.jupiter.api.Test;

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
}