package problem.no51to60;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem52 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=52
        problem("Permuted multiples");
        solution(permutedMultiples());
    }

    private static int permutedMultiples() {
        int i = 0;

        while(true)
            if (permutedDigitsForMultipliersMatch(++i))
                return i;
    }

    private static boolean permutedDigitsForMultipliersMatch(int x) {

        for(int i =  2; i <= 6; i++)
            if (!digitsMatch(x, i))
                return false;

        return true;
    }

    private static boolean digitsMatch(int x, int i) {
        return sortDigits(x).equals(sortDigits(i * x));
    }

    private static String sortDigits(Integer a) {
        return a.toString().chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
