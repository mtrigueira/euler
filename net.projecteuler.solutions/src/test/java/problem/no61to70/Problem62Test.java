package problem.no61to70;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class Problem62Test {
    @Test
    void test0() {
        assertThrows(IllegalArgumentException.class, () -> Problem62.lowestValueWithCubicPermutations(0));
    }

    @Test
    void test1() {
        assertEquals(big(0),Problem62.lowestValueWithCubicPermutations(1));
    }

    @Test
    void test2() {
        assertEquals(big(125), Problem62.lowestValueWithCubicPermutations(2));
    }

    @Test
    void test3() {
        assertEquals(big(41063625), Problem62.lowestValueWithCubicPermutations(3));
    }

    @Test
    void test4() {
        assertEquals(big(1006012008), Problem62.lowestValueWithCubicPermutations(4));
    }

    private static BigInteger big(int val) {
        return BigInteger.valueOf(val);
    }


}
