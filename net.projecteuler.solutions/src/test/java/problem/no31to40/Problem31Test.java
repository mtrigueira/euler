package problem.no31to40;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem31Test {
    @ParameterizedTest(name = "f({1}) = {0}")
    @CsvSource({
            "0,0",
            "1,1",
            "2,2",
            "2,3",
            "3,4",
            "4,5",
            "5,6",
            "6,7"})
    public void countWaysToMakeUsingAnyNumberOfCoins(int expected, int coins) {
        assertEquals(expected, Problem31.countWaysToMakeUsingAnyNumberOfCoins(coins));
    }
}