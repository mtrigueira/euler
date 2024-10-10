package problem.no31to40;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem32Test {

    @Test
    void squish() {
        List<Integer> combination = List.of(1, 2, 3, 4);
        assertEquals(1, Problem32.squish(combination,0,0));
        assertEquals(2, Problem32.squish(combination,1,1));
        assertEquals(3, Problem32.squish(combination,2,2));
        assertEquals(4, Problem32.squish(combination,3,3));
        assertEquals(12, Problem32.squish(combination,0,1));
        assertEquals(23, Problem32.squish(combination,1,2));
        assertEquals(34, Problem32.squish(combination,2,3));
        assertEquals(123, Problem32.squish(combination,0,2));
        assertEquals(234, Problem32.squish(combination,1,3));
        assertEquals(1234, Problem32.squish(combination,0,3));
    }
}