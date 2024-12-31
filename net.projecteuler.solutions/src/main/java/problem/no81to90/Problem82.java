package problem.no81to90;

import utils.FileUtils;
import utils.data.Grid;
import utils.data.GridNumber;

import static problem.Solution.problem;
import static utils.FileUtils.concat;

public class Problem82 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=82
        problem("Path sum: Three ways", () ->
                solution(Grid.of(GridNumber.toShortGrid(concat(FileUtils.getString("/0082_matrix.txt"), "1").replaceAll(",", " ").lines()))));
    }

    static long solution(Grid grid) {
        return grid.findMinPathSumThreeWays();
    }

    private Problem82() {}
}
