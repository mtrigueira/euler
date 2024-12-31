package problem.no91to100;

import java.util.ArrayList;
import java.util.List;

import static problem.Solution.problem;

public class Problem91 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=91
        problem("Right triangles with integer coordinates", () ->
                solution(50));
    }

    static int solution(int i) {
        int count = 0;

        List<Point> points = new ArrayList<>(i);
        for (int x = 0; x <= i; x++)
            for (int y = 0; y <= i; y++)
                points.add(new Point(x, y));

        for (Point P : new ArrayList<>(points))
            for (Point Q : points) {
                Triangle t = Triangle.of(P, Q);
                if (t.areCollinear())
                    continue;

                if (t.anyRightAngle())
                    count++;
            }

        // Double counted since triangle OPQ is OQP
        return count / 2;
    }

    record Triangle(Point A, Point B) {
        static Point C = new Point(0, 0);

        static Triangle of(Point P, Point Q) {
            return new Triangle(P, Q);
        }

        public boolean anyRightAngle() {
            return isRightAngle(B, A, C) ||
                    isRightAngle(A, B, C) ||
                    isRightAngle(A, C, B);
        }

        private boolean isRightAngle(Point b, Point a, Point c) {
            Point AB = new Point(b.x - a.x, b.y - a.y);
            Point AC = new Point(c.x - a.x, c.y - a.y);

            int dotProduct = AB.x * AC.x + AB.y * AC.y;
            return dotProduct == 0;
        }

        private boolean areCollinear() {
            return (B.y - A.y) * (C.x - B.x) == (C.y - B.y) * (B.x - A.x);
        }
    }

    record Point(int x, int y) {
    }

    private Problem91() {}
}
