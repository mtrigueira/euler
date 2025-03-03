package problem;

import utils.sequence.given.CombinationSequence;

import java.util.List;

import static problem.Solution.problem;

public class Problem24 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=24
        problem("Lexicographic permutations",
                () -> permutation(1_000_000, DIGITS));
    }

    public static final String DIGITS = "0123456789";

    static String permutation(int n, String s) {
        List<String> permutation = List.of(s.split(""));

        return new CombinationSequence<>(permutation, (a, b) -> a + b)
                .skip(n - 1)
                .stream()
                .findFirst()
                .orElse("Not found");
    }

    private Problem24() {}
}
