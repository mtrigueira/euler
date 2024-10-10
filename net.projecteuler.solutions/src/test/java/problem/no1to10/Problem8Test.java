package problem.no1to10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static problem.no1to10.Problem8.BIG_NUMBER;

class Problem8Test {
    @Test
    void greatestProductZero() {
        assertEquals(0, Problem8.ofWidth("", 1));
    }

    @Test
    void greatestProductOne() {
        assertEquals(1, Problem8.ofWidth("1", 1));
    }

    @Test
    void greatestProductTwo() {
        assertEquals(2, Problem8.ofWidth("2", 1));
    }

    @Test
    void bigWidthOne() {
        assertEquals(9, Problem8.ofWidth(BIG_NUMBER, 1));
    }

    @Test
    void bigWidthTwo() {
        assertEquals(9*9, Problem8.ofWidth(BIG_NUMBER, 2));
    }

    @Test
    void bigWidthThree() {
        assertEquals(9*9*8, Problem8.ofWidth(BIG_NUMBER, 3));
    }

    @Test
    void bigWidthFour() {
        assertEquals(9*9*8*9, Problem8.ofWidth(BIG_NUMBER, 4));
    }
}