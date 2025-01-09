package problem.no91to100;

import org.junit.jupiter.api.Test;
import utils.FileUtils;

import static org.junit.jupiter.api.Assertions.*;

class Problem98Test {
    @Test
    void sort() {
        assertEquals("ABCDEQRSTUVWXYZ", Problem98.sort("ZYXWVUTSRQEDCBA"));
    }

    @Test
    void lowerSquare() {
        assertEquals(987593476,Problem98.lowerSquare(987654321));
    }

    @Test
    void isValid() {
        assertTrue(Problem98.isValid(123,"ABC"));
        assertTrue(Problem98.isValid(219191,"BANANA"));

        assertFalse(Problem98.isValid(999,"ABC"));
        assertFalse(Problem98.isValid(109,"ABC"));
    }

    @Test
    void crossSubstitute() {
        assertEquals(321, Problem98.crossSubstitute(123,"ABC","CBA"));
    }

    @Test
    void solutionNone() {
        assertEquals(-1,Problem98.solution(FileUtils.concat(null,"")));
    }

    @Test
    void solution() {
        assertEquals(961,Problem98.solution(FileUtils.concat(null,"TEA\nEAT")));
    }
}