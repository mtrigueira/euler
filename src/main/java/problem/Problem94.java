package problem;

import static problem.Solution.problem;

public class Problem94 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=94
        problem("Almost equal triangles", () ->
                solution(1_000_000_000));
    }

    static long solution(int limit) {
        long sum = 0;
        int[] aMinus = new int[]{0, 241, 65, 17, 5};

        for (int i = 1; i < aMinus.length; i++)
            sum += perimeter(aMinus[i], isUniqueSideShorter(i));

        for (boolean isUniqueSideShorter = true;;isUniqueSideShorter=!isUniqueSideShorter) {
            int equalSideLength = nextInSequence(aMinus, isUniqueSideShorter);
            int perimeter = perimeter(equalSideLength, isUniqueSideShorter);

            if (sum + perimeter > limit)
                break;
            sum += perimeter;

            shiftHistory(aMinus, equalSideLength);
        }

        return sum;
    }

    private static int nextInSequence(int[] aMinus, boolean isUniqueSideShorter) {
        return 14 * aMinus[2] - aMinus[4] + (isUniqueSideShorter ? -4 : 4);
    }

    private static void shiftHistory(int[] aMinus, int equalSideLength) {
        for (int j = 4; j > 0; j--)
            aMinus[j] = aMinus[j - 1];
        aMinus[1] = equalSideLength;
    }

    private static int perimeter(int aMinus1, boolean isUniqueSideShorter) {
        return 3 * aMinus1 + (isUniqueSideShorter ? 1 : -1);
    }

    private static boolean isUniqueSideShorter(int i) {
        return (i & 1) == 1;
    }

    private Problem94() {}
}
