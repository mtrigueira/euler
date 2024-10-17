package problem.no51to60;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem56 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=56
        problem("Powerful digit sum");
        solution(powerfulDigitSum());
    }

    private static int powerfulDigitSum() {
        return IntStream.rangeClosed(1, 100)
                .map(a -> IntStream.rangeClosed(1, 100)
                        .mapToObj(b -> BigInteger.valueOf(a).pow(b).toString())
                        .mapToInt(s -> s.chars().map(c -> c - '0').sum()
                        )
                        .max()
                        .orElse(0)
                )
                .max().orElse(0);
    }
}
