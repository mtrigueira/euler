package problem.no71to80;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem76Test {

    @ParameterizedTest
    @CsvSource({"0,1","1,2","2,3","4,4","6,5","10,6","14,7","21,8","29,9"})
    void solution(int expected, int i) {
        assertEquals(expected,Problem76.solution(i));
    }
}