package problem;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Problem93Test {
    @Test
    void consecutiveTargetNumbers() {
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 30, 32, 36),
                Problem93.eval(1, 2, 3, 4));
    }

    @Test
    void solutionTest() {
        assertEquals("1234",
                Problem93.solution(5));
    }

    @Test
    void consecutiveTest() {
        for(int j = 0; j<10; j++) {
            Set<Integer> integers = new HashSet<>();
            if(j>0)
                integers.add(-j);
            for (int i = 1; i < 100; i++) {
                integers.add(i);
                assertEquals(i, Problem93.consecutive(integers));
            }
        }
    }
}