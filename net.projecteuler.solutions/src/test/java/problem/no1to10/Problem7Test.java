package problem.no1to10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.prime.Prime;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem7Test {
    @ParameterizedTest(name = "prime({0}) = {1}")
    @CsvSource({
            "1, 2",
            "2, 3",
            "3, 5",
            "4, 7",
            "5, 11",
            "6, 13",
            "7, 17",
            "8, 19",
            "9, 23",
            "10, 29",
            "11, 31",
            "12, 37",
            "13, 41",
            "14, 43",
            "15, 47",
            "16, 53",
            "17, 59",
            "18, 61",
            "19, 67",
            "20, 71",
            "21, 73",
            "22, 79",
            "23, 83",
            "24, 89"})
    void test(int n, int i) {
        Prime big = Prime.of(BigInteger.valueOf(i)).orElseThrow();
        assertEquals(big, Problem7.prime(n));
    }


}
