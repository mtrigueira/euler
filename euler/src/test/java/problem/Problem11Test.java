package problem;

import org.junit.jupiter.api.Test;
import utils.data.Grid;

import static org.junit.jupiter.api.Assertions.*;

class Problem11Test {
    private static final Grid GRID = Grid.of(new short[][]{{2, 1}, {1, 2}});

    @Test
    void maxProductInGridOfAdjacentCells() {
        assertEquals(4, Problem11.maxProductInGridOfAdjacentCells(GRID,2));
    }
}