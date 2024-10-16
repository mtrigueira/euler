package problem.no11to20;

import utils.FileUtils;
import utils.data.Triangle;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem18 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=18
        problem("Maximum path sum I");
        solution(TRIANGLE.maxPathSum());
    }

    static final Triangle TRIANGLE = Triangle.of(FileUtils.getString("/0018_triangle.txt"));
}
