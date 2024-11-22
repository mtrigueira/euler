package problem.no61to70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem74Test {
    @Test
    void calculateChainLengths() {
        Problem74 problem74 = new Problem74(872);
        int[] a = problem74.chainLength;
        assertEquals(6,a[69]);
        assertEquals(4,a[78]);
        assertEquals(1, a[145]);
        assertEquals(3, a[169]);
        assertEquals(2, a[540]);
        assertEquals(2, a[871]);
        assertEquals(2, a[872]);
    }
}