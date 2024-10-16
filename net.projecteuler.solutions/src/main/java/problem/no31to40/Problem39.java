package problem.no31to40;

import utils.PythagoreanTriangle;

import java.util.stream.IntStream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem39 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=39
        problem("Integer right triangles");
        solution(maximumRightTriangleSolutionsForPerimiterLessThanOrEqualTo(1000));
    }

    private static int maximumRightTriangleSolutionsForPerimiterLessThanOrEqualTo(int limit) {
        return IntStream.rangeClosed(1, limit)
                .mapToObj(p -> new Ugly(p, countSolutionsFor(p)))
                .reduce((a, b) -> a.count > b.count ? a : b)
                .map(u -> u.perimeter).orElse(0);
    }

    static long countSolutionsFor(int perimiter) {
        return IntStream.range(1, perimiter).boxed().flatMap(a ->
                IntStream.range(a, perimiter).mapToObj(b ->
                        PythagoreanTriangle.isPythagoreanTriplet(a, b, PythagoreanTriangle.calculateC(a, b, perimiter))
                ).filter(t -> t)
        ).count();
    }

    record Ugly(int perimeter,long count) {}
}
