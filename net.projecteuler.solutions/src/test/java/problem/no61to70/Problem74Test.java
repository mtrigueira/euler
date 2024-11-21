package problem.no61to70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem74Test {
    @Test
    void calculateChainLengths() {
        int[] a = Problem74.calculateChainLengths(872);
        assertEquals(a[69],5);
        assertEquals(a[78],4);
        assertEquals(a[145], 1);
        assertEquals(a[169], 3);
        assertEquals(a[540], 2);
        assertEquals(a[871], 2);
        assertEquals(a[872], 2);
    }
}