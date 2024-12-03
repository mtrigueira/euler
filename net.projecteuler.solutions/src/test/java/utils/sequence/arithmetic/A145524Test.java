package utils.sequence.arithmetic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class A145524Test {
    @ParameterizedTest
    @CsvSource({"1,1", "2,9", "3,74", "4,449", "5,599", "6,11224", "7,55374"})
    void a145524(int n,int expected) {
        assertEquals(expected, A145524.a(n));
    }
}