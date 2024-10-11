package problem.no31to40;

import utils.sequence.given.CombinationSequence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem32 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=32
        CombinationSequence<String> combiner = new CombinationSequence<>(DIGITS, (a, b) -> a + b);

        while (combiner.hasNext())
            accumulateWhereIdentityMatches(combiner.next());

        System.out.println(
                products.stream()
                        .mapToInt(x -> x)
                        .sum()
        );
    }

    private static final Set<Integer> products = new HashSet<>();

    private static void accumulateWhereIdentityMatches(String combination) {
        for (int i = 0; i < combination.length() - 3; i++)
            for (int j = i + 1; j < combination.length() - 2; j++)
                addIfIdentityMatches(combination, i, j);
    }

    private static void addIfIdentityMatches(String combination, int i, int j) {
        int multiplicand = squish(combination, 0, i);
        int multiplier = squish(combination, i + 1, j);
        int product = squish(combination, j + 1, combination.length() - 1);

        if (multiplicand * multiplier == product)
            products.add(product);
    }

    static int squish(String combination, int start, int end) {
        return Integer.parseInt(combination.substring(start, end + 1));
    }

    private static final List<String> DIGITS = List.of("123456789".split(""));
}
