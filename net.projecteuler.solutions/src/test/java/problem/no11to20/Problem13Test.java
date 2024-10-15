package problem.no11to20;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem13Test {
    @ParameterizedTest
    @ValueSource(strings = {
            "0:0",
            "1:0,1",
            "12:0,1,11",
            "12345678901234567890123456789012345678901234567890:12345678901234567890123456789012345678901234567890",
            "12345678901234567890123456789012345678901234567891:12345678901234567890123456789012345678901234567890,1",
            "999999999999999999999999999999999999999999999999999:12345678901234567890123456789012345678901234567890,987654321098765432109876543210987654321098765432109",
            "1000000000000000000000000000000000000000000000000000:12345678901234567890123456789012345678901234567890,987654321098765432109876543210987654321098765432109,1"
    })
    void sum(String testRow) {
        String[] temp = testRow.split(":");
        String expected = temp[0];
        Stream<String> numbers = Arrays.stream(temp[1].split(","));

        assertEquals(expected, Problem13.sum(numbers));
    }
}