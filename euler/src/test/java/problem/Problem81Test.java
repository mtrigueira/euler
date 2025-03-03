package problem;

import org.junit.jupiter.api.Test;
import utils.data.Grid;
import utils.data.GridNumber;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem81Test {
    private static final Grid reloaded = Grid.of(GridNumber.toShortGrid(Arrays.stream((
            """
                    0 673 234 103 18
                    0 96 342 965 150
                    0 0 0 422 111
                    537 699 0 121 956
                    805 732 0 0 0""").split("\\R"))));
    private static final Grid matrix = Grid.of(GridNumber.toShortGrid(Arrays.stream((
            """
                    131 673 234 103 18
                    201 96 342 965 150
                    630 803 746 422 111
                    537 699 497 121 956
                    805 732 524 37 331""").split("\\R"))));
    @Test
    void solutionReloaded() {
        assertEquals(0, Problem81.solution(reloaded));
    }
    @Test
    void solutionMatrix() {
        assertEquals(2427,Problem81.solution(matrix));
    }
}