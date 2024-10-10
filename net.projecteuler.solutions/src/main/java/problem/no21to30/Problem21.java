package problem.no21to30;

import utils.property.ProperDivisors;

import java.util.Set;

public class Problem21 {
    public static final int LIMIT = 10000;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=21
        System.out.println(below(LIMIT));
    }

    static int below(int limit) {
        return new Problem21(limit - 1).sum();
    }

    private int sum() {
        int sum = 0;

        for (int i = 1; i < sums.length; i++)
            if (hasAmicable(i))
                sum += i;

        return sum;
    }

    boolean hasAmicable(int i) {
        long sum = sums[i];
        if (sum == i) return false;
        if (sum >= sums.length) return sumOfProperDivisors(sum) == i;

        return sums[(int) sum] == i;
    }

    private final long[] sums;

    Problem21(int limit) {
        sums = new long[limit + 1];
        for (int i = 1; i <= limit; i++)
            sums[i] = sumOfProperDivisors(i);
    }

    private static long sumOfProperDivisors(long i) {
        return sum(ProperDivisors.of(i));
    }

    boolean areAmicable(int a, int b) {
        return a != b && (sums[a] == b) && (sums[b] == a);
    }

    private static long sum(Set<Long> set) {
        return set.stream().reduce(0L, Long::sum);
    }
}
