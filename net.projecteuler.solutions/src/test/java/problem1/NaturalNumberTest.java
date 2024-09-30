package problem1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberTest {
    @ParameterizedTest(name = "sumOfNaturalNumbersTo({0}) = {1}")
    @CsvSource({
            "1, 1",
            "2, 3",
            "3, 6",
            "4, 10",
            "5, 15",
            "6, 21",
            "7, 28",
            "8, 36",
            "9, 45",
            "10, 55"
    })
    void checkSumToIs(int n, int expected) {
        assertEquals(expected, NaturalNumber.sumTo(n));
    }
}