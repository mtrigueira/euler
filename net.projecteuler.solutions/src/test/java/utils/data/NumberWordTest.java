package utils.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberWordTest {
    static int indexIsNumber = 1;
    static int indexIsTen = 1;
    static int indexIsOneHundredAnd = 0;

    @ParameterizedTest
    @ValueSource(strings =
            {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                    "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five",
                    "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "thirty", "thirty-one"})
    void of1digit(String word) {
        assertEquals(word, NumberWord.of(indexIsNumber++));
    }

    @ParameterizedTest
    @ValueSource(strings =
            {"ten", "twenty", "thirty","forty","fifty","sixty","seventy", "eighty", "ninety", "one hundred"})
    void ofTens(String word) {
        assertEquals(word, NumberWord.of(10*indexIsTen++));
    }
    @ParameterizedTest
    @ValueSource(strings = {"one hundred", "one hundred and one", "one hundred and two"})
    void ofHundredAnds(String word) {
        assertEquals(word, NumberWord.of(100+indexIsOneHundredAnd++));
    }

@Test
    void limitPlusOneTest() {
        assertThrows(IllegalArgumentException.class, () -> NumberWord.of(1001));
    }


    @Test
    void limitMinusOneTest() {
        assertThrows(IllegalArgumentException.class, () -> NumberWord.of(0));
    }
}