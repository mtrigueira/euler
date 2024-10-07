package problem.no21to30.problem29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistinctPowersTest {
    @Test
    void testDistinctPowers2and2() {
        assertEquals(1, DistinctPowers.numberOfDistinctTerms(2, 2));
    }

    @Test
    void testDistinctPowers3and2() {
        assertEquals(2, DistinctPowers.numberOfDistinctTerms(3, 2));
    }

    @Test
    void testDistinctPowers3and3() {
        assertEquals(4, DistinctPowers.numberOfDistinctTerms(3, 3));
    }

    @Test
    void testDistinctPowers5and5() {
        assertEquals(15, DistinctPowers.numberOfDistinctTerms(5, 5));
    }
}