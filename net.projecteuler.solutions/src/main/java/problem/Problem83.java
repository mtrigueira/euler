package problem;

import utils.FileUtils;
import utils.data.Grid;
import utils.data.GridNumber;

import static problem.Solution.problem;
import static utils.FileUtils.concat;

public class Problem83 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=83
        problem("Path sum: Four ways", () ->
                solution(Grid.of(GridNumber.toShortGrid(concat(FileUtils.getString("/0082_matrix.txt"), "1").replaceAll(",", " ").lines()))));
    }

    static long solution(Grid grid) {
        return grid.findMinPathSumFourWays();
    }

    private Problem83() {}
}
