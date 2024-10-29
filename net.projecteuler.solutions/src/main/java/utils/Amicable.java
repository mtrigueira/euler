package utils;

import utils.property.ProperDivisors;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Amicable {
    private final long[] sums;

    public Amicable(int limit) {
        sums = new long[limit + 1];
        IntStream.rangeClosed(1, limit)
                .forEach(i -> sums[i] = sumOfProperDivisors(i));
    }

    private static long sumOfProperDivisors(long i) {
        return ProperDivisors.of(i)
                .stream()
                .reduce(BigInteger.ZERO, BigInteger::add)
                .longValueExact();
    }

    public int sum() {
        return IntStream.range(1, sums.length)
                .filter(this::hasAmicable)
                .sum();
    }

    public boolean hasAmicable(int i) {
        long sum = sums[i];
        if (sum == i) return false;
        if (sum >= sums.length) return sumOfProperDivisors(sum) == i;

        return sums[(int) sum] == i;
    }
}
