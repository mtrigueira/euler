package problem.no11to20;

import utils.FileUtils;
import utils.data.Grid;
import utils.data.GridNumber;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem11 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=11
        problem("Largest product in a grid");
        solution(maxProductInGridOfAdjacentCells(GRID, 4));
    }

    public static final Grid GRID = Grid.of(GridNumber.toShortGrid(FileUtils.getStrings("/0011_grid.txt")));

    static int maxProductInGridOfAdjacentCells(Grid grid, int cells) {
        return grid.findMaxProduct(cells);
    }
}