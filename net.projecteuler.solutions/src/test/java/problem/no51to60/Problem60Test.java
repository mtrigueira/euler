package problem.no51to60;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem60Test {
    @Test
    void test2() {
        assertEquals(10, Problem60.sumOfPrimePairSets(2));
    }

    @Test
    void test3() {
        assertEquals(107, Problem60.sumOfPrimePairSets(3));
    }

    @Test
    void test4() {
        assertEquals(792, Problem60.sumOfPrimePairSets(4));
    }
}