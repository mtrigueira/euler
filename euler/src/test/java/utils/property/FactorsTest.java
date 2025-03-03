package utils.property;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.Maker;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.property.Factors.countRelativePrimes;
import static utils.property.Factors.findRelativePrimes;

class FactorsTest {
    @Test
    void factorsZERO() {
        assertEquals(Collections.emptySet(), Factors.of(BigInteger.ZERO));
    }

    @Test
    void factorsONE() {
        assertEquals(Maker.set(1), Factors.of(BigInteger.ONE));
    }

    @Test
    void factors0() {
        assertEquals(Collections.emptySet(), Factors.of(0));
    }

    @Test
    void factors1() {
        Assertions.assertEquals(Maker.setL(1), Factors.of(1));
    }

    @Test
    void factors3() {
        assertEquals(Maker.setL(1, 3), Factors.of(3));
    }

    @Test
    void factors6() {
        assertEquals(Maker.setL(1, 2, 3, 6), Factors.of(6));
    }

    @Test
    void factors28() {
        assertEquals(Maker.setL(1, 2, 4, 7, 14, 28), Factors.of(28));
    }


    @ParameterizedTest
    @CsvSource({"2,1", "3,1;2", "4,1;3", "5,1;2;3;4", "6,1;5", "7,1;2;3;4;5;6", "8,1;3;5;7", "9,1;2;4;5;7;8", "10,1;3;7;9"})
    void findRelativePrimesTest(int n, String relativePrimes) {
        List<Integer> expected = Arrays.stream(relativePrimes.split(";")).mapToInt(Integer::parseInt).boxed().toList();
        assertEquals(expected, findRelativePrimes(n));
    }

    @ParameterizedTest
    @CsvSource({"2,1","3,2","4,2","5,4","6,2","7,6","8,4","9,6","10,4"})
    void countRelativePrimesTest(int n, int phi) {
        assertEquals(phi, countRelativePrimes(n));
    }
}