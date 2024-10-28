package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TripletTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, 0",
            "0, 0, 1, 1",
            "0, 1, 1, 2",
            "1, 1, 1, 3",
            "1, 1, 2, 4",
            "3, 4, 5, 12",
            "5, 12, 13, 30",
            "8, 15, 17, 40",
            "7, 24, 25, 56",
            "20, 21, 29, 70",
            "12, 35, 37, 84",
            "9, 40, 41, 90"
    })
    void sumTest(int a, int b, int c, int sum) {
        assertEquals(sum, Triplet.of(a, b, c).sum());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, 0",
            "0, 0, 1, 0",
            "0, 1, 1, 0",
            "1, 1, 1, 1",
            "1, 1, 2, 2",
            "3, 4, 5, 60",
            "5, 12, 13, 780",
            "8, 15, 17, 2040",
            "7, 24, 25, 4200",
            "20, 21, 29, 12180",
            "12, 35, 37, 15540",
            "9, 40, 41, 14760"
    })
    void productTest(int a, int b, int c, int product) {
        assertEquals(product, Triplet.of(a, b, c).product());
    }

    @Test
    void toStringTest() {
        assertEquals("{1, 2, 3}", Triplet.of(1, 2, 3).toString());
    }
}