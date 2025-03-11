package problem;

import static problem.Solution.problem;

public class Problem39 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=39
        problem("Integer right triangles",
                () -> maximumRightTriangleSolutionsForPerimeterLessThanOrEqualTo(1000));
    }

    static int maximumRightTriangleSolutionsForPerimeterLessThanOrEqualTo(int limit) {
        int accPerimiter = 0;
        long accCount = 0;

        for (int p = 1; p <= limit; p++)
            if (accCount < countSolutionsFor(p)) {
                accPerimiter = p;
                accCount = countSolutionsFor(p);
            }

        return accPerimiter;
    }

    static long countSolutionsFor(int perimeter) {
        long count = 0L;

        for (long a = 1; a < perimeter; a++) {
            long a2 = a * a;
            for (long b = a; b < perimeter - a; b++) {
                long c = perimeter - a - b;
                if (a2 + b * b == c * c)
                    count++;
            }
        }

        return count;
    }

    private Problem39() {}
}
