package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem79Test {
    @Test
    void shortestPasscode() {
        assertEquals("1234", Problem79.shortestPasscode("123,234".split(",")));
    }

    @Test
    void noShortestPasscode() {
        assertThrows(RuntimeException.class,()->Problem79.shortestPasscode("123,321".split(",")));
    }
}