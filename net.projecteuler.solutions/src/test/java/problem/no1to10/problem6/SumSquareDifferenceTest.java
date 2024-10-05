package problem.no1to10.problem6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumSquareDifferenceTest {
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 4",
            "3, 22",
            "4, 70",
            "10, 2640"
    })

    void sumOfSquaresIs(int i, int expected) {
        assertEquals(expected, SumSquareDifference.of(i));
    }

}
