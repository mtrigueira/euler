package problem.no31to40;

import utils.PythagoreanTriangle;

import java.util.stream.IntStream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem39 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=39
        problem("Integer right triangles");
        solution(maximumRightTriangleSolutionsForPerimeterLessThanOrEqualTo(1000));
    }

    static int maximumRightTriangleSolutionsForPerimeterLessThanOrEqualTo(int limit) {
        return IntStream.rangeClosed(1, limit)
                .mapToObj(p -> new Ugly(p, countSolutionsFor(p)))
                .reduce((a, b) -> a.count > b.count ? a : b)
                .map(u -> u.perimeter).orElse(0);
    }

    static long countSolutionsFor(int perimeter) {
        return IntStream.range(1, perimeter).boxed().flatMap(a ->
                IntStream.range(a, perimeter).mapToObj(b ->
                        PythagoreanTriangle.isPythagoreanTriplet(a, b, PythagoreanTriangle.calculateC(a, b, perimeter))
                ).filter(t -> t)
        ).count();
    }

    record Ugly(int perimeter,long count) {}
}
