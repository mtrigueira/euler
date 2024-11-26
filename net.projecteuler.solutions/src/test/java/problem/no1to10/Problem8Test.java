package problem.no1to10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem8Test {
    @Test
    void greatestProductOfAdjacentDigits() {
        assertEquals(120, Problem8.greatestProductOfAdjacentDigits(4, "12345"));
    }
}