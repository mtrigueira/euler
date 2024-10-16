package problem.no1to10;

import org.junit.jupiter.api.Test;
import utils.sequence.given.WideNumberProductSequence;

import static org.junit.jupiter.api.Assertions.*;

class Problem8Test {
    private static final String BIG_NUMBER = "123456789";

    @Test
    void greatestProductZero() {
        assertEquals(0, (long) new WideNumberProductSequence("", 1).stream().reduce(0L, Long::max));
    }

    @Test
    void greatestProductOne() {
        assertEquals(1, (long) new WideNumberProductSequence("1", 1).stream().reduce(0L, Long::max));
    }

    @Test
    void greatestProductTwo() {
        assertEquals(2, (long) new WideNumberProductSequence("2", 1).stream().reduce(0L, Long::max));
    }

    @Test
    void bigWidthOne() {
        assertEquals(9, (long) new WideNumberProductSequence(BIG_NUMBER, 1).stream().reduce(0L, Long::max));
    }

    @Test
    void bigWidthTwo() {
        assertEquals(9*8, (long) new WideNumberProductSequence(BIG_NUMBER, 2).stream().reduce(0L, Long::max));
    }

    @Test
    void bigWidthThree() {
        assertEquals(9*8*7, (long) new WideNumberProductSequence(BIG_NUMBER, 3).stream().reduce(0L, Long::max));
    }

    @Test
    void bigWidthFour() {
        assertEquals(9*8*7*6, (long) new WideNumberProductSequence(BIG_NUMBER, 4).stream().reduce(0L, Long::max));
    }
}