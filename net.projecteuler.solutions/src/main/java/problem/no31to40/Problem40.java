package problem.no31to40;

import utils.sequence.arithmetic.ChampernowneSequence;

import java.util.concurrent.atomic.AtomicInteger;

import static problem.Solution.problem;

public class Problem40 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=40
        problem("Champernowne's constant",
        () -> productOfChampernownesDigetsAtPositionsMod10Below(1_000_000));
    }

    static int productOfChampernownesDigetsAtPositionsMod10Below(int limit) {
        AtomicInteger i = new AtomicInteger(0);
        return new ChampernowneSequence().stream()
                .limit(limit)
                .filter(a -> isIndexOfInterest(i.incrementAndGet()))
                .mapToInt(Integer::valueOf)
                .reduce(1, (a, b) -> a * b);
    }

    private static boolean isIndexOfInterest(int i) {
        int digits = (int) Math.log10(i) + 1;
        int pow = (int) Math.pow(10, digits - 1);
        return i == pow;
    }
}
