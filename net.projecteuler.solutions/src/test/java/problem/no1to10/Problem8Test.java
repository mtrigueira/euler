package problem.no1to10;

import org.junit.jupiter.api.Test;
import utils.sequence.given.WideNumberProductSequence;

import static org.junit.jupiter.api.Assertions.*;
import static problem.no1to10.Problem8.BIG_NUMBER;

class Problem8Test {
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
        assertEquals(9*9, (long) new WideNumberProductSequence(BIG_NUMBER, 2).stream().reduce(0L, Long::max));
    }

    @Test
    void bigWidthThree() {
        assertEquals(9*9*8, (long) new WideNumberProductSequence(BIG_NUMBER, 3).stream().reduce(0L, Long::max));
    }

    @Test
    void bigWidthFour() {
        assertEquals(9*9*8*9, (long) new WideNumberProductSequence(BIG_NUMBER, 4).stream().reduce(0L, Long::max));
    }
}