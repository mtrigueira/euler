package problem.no1to10.problem1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplesOf3or5Test {
    @ParameterizedTest(name = "sum({0}) = {1}")
    @CsvSource({
            "2, 0",
            "3, 0",
            "4, 3",
            "5, 3",
            "6, 8",
            "7, 14",
            "10, 23",
            "11, 33",
            "16, 60"
    })
    void sumIsTest(int value, int expectedSum) {
        assertEquals(expectedSum, MultiplesOf3or5.naturalNumberSumOfMultiplesOf3or5(value));
    }
}
