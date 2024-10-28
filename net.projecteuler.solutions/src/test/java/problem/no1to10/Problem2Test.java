package problem.no1to10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem2Test {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "2, 2",
            "10, 8",
            "44, 34",
            "188, 144",
            "798, 610",
            "3382, 2584",
            "14328, 10946",
            "60696, 46368",
            "257114, 196418",
            "1089154, 832040",
            "4613732, 3524578"
    })
    void assertSumForLimit(int expected, int limit) {
        BigInteger b = BigInteger.valueOf(expected);
        assertEquals(b, Problem2.sum(limit));
    }


}