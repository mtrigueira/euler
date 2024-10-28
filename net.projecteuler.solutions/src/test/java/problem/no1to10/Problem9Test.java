package problem.no1to10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.Triplet;

import static org.junit.jupiter.api.Assertions.*;

class Problem9Test {
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3"
    })
    void invalid(int a, int b, int c) {
        assertFalse(isSpecialTriplet(a, c, b));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5",
            "5, 12, 13",
            "8, 15, 17",
            "7, 24, 25",
            "20, 21, 29",
            "12, 35, 37",
            "9, 40, 41",
            "28, 45, 53",
            "11, 60, 61",
            "16, 63, 65",
            "33, 56, 65",
            "48, 55, 73",
            "13, 84, 85",
            "36, 77, 85",
            "39, 80, 89",
            "65, 72, 97"
    })
    void specialTriplet(int a, int b, int c) {
        assertTrue(isSpecialTriplet(a,b,c));
    }

    static boolean isSpecialTriplet(int a, int b, int c) {
        var t = Triplet.of(a, b, c);
        return t.product()== Problem9.productWhenSumEquals(t.sum());
    }


}
