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
        solution(GRID.findMaxProduct(4));
    }

    static final Grid GRID = Grid.of(GridNumber.toShortGrid(FileUtils.getStrings("/0011_grid.txt")));
}