package utils;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static org.junit.jupiter.api.Assertions.*;

class MakerTest {
    public static final BigInteger THREE = BigInteger.valueOf(3);
    public static final BigInteger FOUR = BigInteger.valueOf(4);
    public static final BigInteger FIVE = BigInteger.valueOf(5);

    @Test
    void set() {
        assertEquals(Set.of(), Maker.set());
    }

    @Test
    void set2() {
        assertEquals(Set.of(ONE), Maker.set(1));
    }

    @Test
    void set3() {
        assertEquals(Set.of(ONE, TWO, THREE, FOUR, FIVE), Maker.set(1, 2, 3, 4, 5));
    }

    @Test
    void list() {
        assertEquals(List.of(ONE, TWO, THREE, FOUR, FIVE), Maker.list(1, 2, 3, 4, 5));
    }
}