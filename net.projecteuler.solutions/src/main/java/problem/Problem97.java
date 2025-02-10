package problem;

import static problem.Solution.problem;

public class Problem97 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=97
        problem("Largest non-mersenne prime", () ->
                solution(10));
    }

    static long solution(int digits) {
        long mask = (long) Math.pow(10, digits);
        long result = 2;

        for (long exp = 7830457; exp > 1; exp--)
            result = (result * 2) % mask;

        result = 28433 * result + 1;
        result %= mask;

        return result;
    }

    private Problem97() {}
}
