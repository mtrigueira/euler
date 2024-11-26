package problem.no71to80;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static problem.Solution.problem;

public class Problem75 {
    private Problem75() {
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=75
        problem("", () ->
                countSingularRightTriangles(1_500_000));
    }

    static int countSingularRightTriangles(int limit) {
        SortedSet<Integer> uniquePrimitiveTrianglePerimeters = new TreeSet<>();
        Set<Integer> dupes = new HashSet<>();
        for (int n = 1; n < Math.sqrt(limit) - 1; n++) {
            long nSquared = (long) n * n;
            for (int m = n + 1; m < Math.sqrt(limit) - 1; m++) {
                long mSquared = (long) m * m;
                long a = mSquared - nSquared;
                long b = 2L * m * n;
                long c = mSquared + nSquared;
                long perimeter = a + b + c;
                if (perimeter > limit) break;
                if (gcd(gcd(a, b), c) > 1) continue;
                if (!uniquePrimitiveTrianglePerimeters.add((int) perimeter))
                    dupes.add((int) perimeter);
            }
        }
        uniquePrimitiveTrianglePerimeters.removeAll(dupes);

        int[] sieve = new int[limit + 1];
        for (int p : uniquePrimitiveTrianglePerimeters)
            for (int i = p; i <= limit; i += p)
                sieve[i]++;

        int count = 0;
        for (int i = 0; i <= limit; i++)
            if (sieve[i] == 1) count++;

        return count;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
