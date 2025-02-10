package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem66Test {
    @Test
    void largestXforDLessThanOrEqual() {
        assertEquals(5, Problem66.largestXForDLessThanOrEqual(7));
    }

    @Test
    void largestXforDLessThanOrEqual1() {
        assertEquals(0, Problem66.largestXForDLessThanOrEqual(1));
    }
}