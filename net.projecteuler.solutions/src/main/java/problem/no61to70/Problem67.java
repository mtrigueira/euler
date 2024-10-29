package problem.no61to70;

import utils.FileUtils;
import utils.data.Triangle;

import static problem.Solution.problem;

public class Problem67 {
    private Problem67() {}

    private static final String TRIANGLE = FileUtils.getString("/0067_triangle.txt");

    public static void main(String[] args) {
        // https://projecteuler.net/problem=67
        problem("Maximum path sum II",
        () -> Triangle.of(TRIANGLE).maxPathSum());
    }
}
