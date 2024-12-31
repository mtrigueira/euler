package problem.no11to20;

import utils.FileUtils;
import utils.data.Grid;
import utils.data.GridNumber;

import static problem.Solution.problem;
import static utils.FileUtils.concat;

public class Problem11 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=11
        problem("Largest product in a grid",
                () -> maxProductInGridOfAdjacentCells(GRID, 4));
    }

    public static final Grid GRID = Grid.of(GridNumber.toShortGrid(concat(FileUtils.getStrings("/0011_grid.txt"), "2 1\n1 2")));

    static int maxProductInGridOfAdjacentCells(Grid grid, int cells) {
        return grid.findMaxProduct(cells);
    }

    private Problem11() {}
}