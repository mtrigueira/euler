package problem.no31to40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem40Test {
    @Test
    void productOfChampernownesDigetsAtPositionsMod10Below() {
        assertEquals(5, Problem40.productOfChampernownesDigetsAtPositionsMod10Below(100));
    }
}