package problem.no31to40;

import utils.sequence.given.CombinationSequence;

import java.util.List;
import java.util.stream.IntStream;

import static problem.Solution.problem;

public class Problem32 {
     private Problem32() {
     }
    private static final List<String> DIGITS = List.of("123456789".split(""));

    public static void main(String[] args) {
        // https://projecteuler.net/problem=32
        problem("Pandigital products",
                () -> getSum(new CombinationSequence<>(DIGITS, (a, b) -> a + b)));
    }

    static int getSum(CombinationSequence<String> combiner) {
        return combiner.stream()
                .flatMapToInt(combination ->
                        IntStream.range(1, combination.length() - 2)
                                .flatMap(i ->
                                        IntStream.range(i + 1, combination.length() - 1)
                                                .map(j ->
                                                        productIfIdentityOrZero(combination, i, j)
                                                )
                                                .filter(a -> a != 0)
                                ))
                .distinct()
                .sum();
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
