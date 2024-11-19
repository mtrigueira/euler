package problem.no71to80;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem71Test {
    @Test
    void orderedFractionToLeftOfWhere() {
        assertEquals(2,Problem71.orderedFractionToLeftOfWhere(3,7,8));
    }

    @Test
    void orderedFractionToLeftOfWhere10() {
        assertEquals(3,Problem71.orderedFractionToLeftOfWhere(5,8,10));
    }
}