package problem;

import utils.FileUtils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static problem.Solution.problem;

public class Problem99 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=99
        problem("Largest exponential", () ->
                solution(NUMBERS));
    }

    public static final Stream<String> NUMBERS =
            FileUtils.concat(
            FileUtils.getStrings("/0099_base_exp.txt"), "519432,525806\n" +
                            "632382,518061");
    private static final Pair NOT_FOUND = new Pair(-1, Double.MIN_VALUE);

    static int solution(Stream<String> numbers) {
        AtomicInteger i = new AtomicInteger();
        Pair max = numbers
                .map(line -> {
                    String[] split = line.split(",");
                    int base = Integer.parseInt(split[0]);
                    int exp = Integer.parseInt(split[1]);

                    return new Pair(i.incrementAndGet(), exp * Math.log(base));
                }).reduce(NOT_FOUND,(a, b) -> a.d > b.d ? a : b);

        return max.i;
    }

    record Pair(int i, double d) {}

    private Problem99() {}
}
