package problem.no31to40;

import utils.sequence.given.CombinationSequence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem32 {
    private static final List<String> DIGITS = List.of("123456789".split(""));

    public static void main(String[] args) {
        // https://projecteuler.net/problem=32
        problem("Pandigital products");
        CombinationSequence<String> combiner = new CombinationSequence<>(DIGITS, (a, b) -> a + b);

        solution(combiner.stream().flatMap(Problem32::accumulateWhereIdentityMatches)
                .distinct().mapToInt(x -> x).sum());
    }

    private static Stream<Integer> accumulateWhereIdentityMatches(String combination) {
        Set<Integer> products = new HashSet<>();

        for (int i = 0; i < combination.length() - 3; i++)
            for (int j = i + 1; j < combination.length() - 2; j++)
                products.add(productIfIdentityOrZero(combination, i, j));

        return products.stream().filter(a -> a != 0);
    }

    private static int productIfIdentityOrZero(String combination, int i, int j) {
        int multiplicand = squish(combination, 0, i);
        int multiplier = squish(combination, i + 1, j);
        int product = squish(combination, j + 1, combination.length() - 1);

        return multiplicand * multiplier == product ? product : 0;
    }

    static int squish(String combination, int start, int end) {
        return Integer.parseInt(combination.substring(start, end + 1));
    }
}
