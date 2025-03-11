package problem;

import org.junit.jupiter.api.Test;
import utils.data.Grid;
import utils.data.GridNumber;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem83Test {
    @Test
    void degenerate() {
        assertEquals(0, Problem83.solution(Grid.of(new short[][]{{}})));
    }

    @Test
    void singular() {
        assertEquals(42, Problem83.solution(Grid.of(new short[][]{{42}})));
    }

    @Test
    void flat() {
        assertEquals(42, Problem83.solution(Grid.of(new short[][]{{2,3,7,30}})));
    }

    @Test
    void tall() {
        assertEquals(42, Problem83.solution(Grid.of(new short[][]{{2},{3},{7},{30}})));
    }

    @Test
    void leftThenUp() {
        assertEquals(42, Problem83.solution(Grid.of(new short[][]{
                {9,99},
                {8,25}})));
    }

    @Test
    void upThenLeft() {
        assertEquals(42, Problem83.solution(Grid.of(new short[][]{
                {9,8},
                {99,25}})));
    }

    @Test
    void leftUpUpLeft() {
        assertEquals(5, Problem83.solution(Grid.of(new short[][]{
                {1,1,9},
                {9,1,9},
                {9,1,1}})));
    }

    @Test
    void upLeftUpLeft() {
        assertEquals(5, Problem83.solution(Grid.of(new short[][]{
                {1,1,9},
                {9,1,1},
                {9,9,1}})));
    }

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
        assertEquals(0,Problem83.solution(reloaded));
    }
    @Test
    void solutionMatrix() {
        assertEquals(2297,Problem83.solution(matrix));
    }
}