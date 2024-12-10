package problem.no81to90;

import org.junit.jupiter.api.Test;
import utils.data.Grid;
import utils.data.GridNumber;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem82Test {
    private static final Grid reloaded = Grid.of(GridNumber.toShortGrid(Arrays.stream((
            """
                    131 673 234 103 18
                    201 96 342 965 150
                    0 0 0 422 111
                    537 699 0 121 956
                    805 732 0 0 0""").split("\\R"))));
    private static final Grid trinity = Grid.of(GridNumber.toShortGrid(Arrays.stream((
            """
                    0 0 234 103 18
                    201 0 342 0 0
                    630 0 746 0 111
                    537 0 497 0 956
                    805 0 0 0 331""").split("\\R"))));
    private static final Grid matrix = Grid.of(GridNumber.toShortGrid(Arrays.stream((
            """
                    131 673 234 103 18
                    201 96 342 965 150
                    630 803 746 422 111
                    537 699 497 121 956
                    805 732 524 37 331""").split("\\R"))));
    @Test
    void solutionReloaded() {
        assertEquals(0,Problem82.solution(reloaded));
    }
    @Test
    void solutionTrinity() {
        assertEquals(0,Problem82.solution(trinity));
    }
    @Test
    void solutionMatrix() {
        assertEquals(994,Problem82.solution(matrix));
    }
}