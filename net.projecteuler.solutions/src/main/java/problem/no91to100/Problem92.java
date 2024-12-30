package problem.no91to100;

import java.util.HashSet;

import static problem.Solution.problem;

public class Problem92 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=92
        problem("Square digit chains", () ->
                solution(10));
    }

    static int solution(int n) {
        HashSet<Integer> arrivesAtOne = new HashSet<>();
        arrivesAtOne.add(1);

        int current;
        for (int i = 2; i < n; i++) {
            current = i;
            while (!(current < i || current == 89))
                current = squareDigits(current);

            if (arrivesAtOne.contains(current))
                arrivesAtOne.add(i);
        }

        return (n - 1) - arrivesAtOne.size();
    }

    private static int squareDigits(int current) {
        int sum = 0;
        while (current > 0) {
            sum += current % 10 * (current % 10);
            current /= 10;
        }
        return sum;
    }

    private Problem92() {
    }
}
