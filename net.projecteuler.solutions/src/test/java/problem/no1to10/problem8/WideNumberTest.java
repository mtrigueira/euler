package problem.no1to10.problem8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.sequence.given.WideNumberSequence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WideNumberTest {
    private static final WideNumberSequence seriesTwoDigitsWide = new WideNumberSequence("0123456789",2);
    private static final WideNumberSequence series2 = new WideNumberSequence("0123456789",2);
    private static final WideNumberSequence seriesWide = new WideNumberSequence("0123456789",10);

    @ParameterizedTest
    @ValueSource(ints = {1,12,23,34,45,56,67,78,89})
    void cruise2(int expected) {
        assertEquals(expected, seriesTwoDigitsWide.next());
    }

    @Test
    void onlyOneWideNumber() {
        assertEquals(123456789, seriesWide.next());
        assertFalse(seriesWide.hasNext());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,2,6,12,20,30,42,56,72})
    void product(int i) {
        assertEquals(i, series2.product());
        series2.next();
    }
}