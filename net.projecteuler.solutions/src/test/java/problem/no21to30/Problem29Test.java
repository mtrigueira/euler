package problem.no21to30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem29Test {
    @Test
    void testDistinctPowers2and2() {
        assertEquals(1, Problem29.numberOfDistinctTerms(2, 2));
    }

    @Test
    void testDistinctPowers3and2() {
        assertEquals(2, Problem29.numberOfDistinctTerms(3, 2));
    }

    @Test
    void testDistinctPowers3and3() {
        assertEquals(4, Problem29.numberOfDistinctTerms(3, 3));
    }

    @Test
    void testDistinctPowers5and5() {
        assertEquals(15, Problem29.numberOfDistinctTerms(5, 5));
    }


}