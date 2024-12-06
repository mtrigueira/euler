package problem.no31to40;

import utils.sequence.given.CombinationSequence;

import java.util.List;
import java.util.stream.Stream;

import static problem.Solution.problem;

public class Problem32 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=32
        problem("Pandigital products",
                () -> getSum(new CombinationSequence<>(DIGITS, Problem32::concat)));
    }

    private static final List<Long> DIGITS = Stream.of("123456789".split("")).map(Long::parseLong).toList();

    static long concat(long a, long b) {
        return a * (long) Math.pow(10, (long) Math.log10(b) + 1) + b;
    }

    static long getSum(CombinationSequence<Long> combiner) {
        return combiner.stream()
                .mapToLong(c -> {
                    for (int i = 2; i <= digitLength(c) / 3; i++) {
                        long multiplicand = squishTill(c, i);
                        long leftovers = squishFrom(c, i + 1);
                        for (int j = 0; j < 2; j++) {
                            long pow10 = (long) Math.pow(10, (long) Math.log10(leftovers) - j);
                            long product = leftovers % pow10;
                            long delta = multiplicand * (leftovers / pow10) - product;

                            if (delta == 0)
                                return product;
                            if (delta > 0)
                                break;
                        }
                    }
                    return 0;
                })
                .distinct()
                .sum();
    }

    static long squishTill(long a, int end) {
        return (long) (a / Math.pow(10, digitLength(a) - end));
    }

    private static int digitLength(long a) {
        return (int) Math.log10(a);
    }

    static long squishFrom(long a, int start) {
        return (long) (a % Math.pow(10, digitLength(a) + 1 - start));
    }

    private Problem32() {
    }
}
