package problem21;

import java.util.Set;

public class AmicableNumbers {
    public static void main(String[] args) {

        System.out.println(below(10000));
    }

    private static int below(int limit) {
        return new AmicableNumbers(limit).sum();
    }

    private int sum() {
        int sum = 0;

        for (int i = 1; i < sums.length; i++)
            if (hasAmicable(i))
                sum += i;

        return sum;
    }

    boolean hasAmicable(int i) {
        int sum = sums[i];
        if (sum == i) return false;
        if (sum >= sums.length) return false;

        return sums[sum] == i;
    }

    private int[] sums;

    AmicableNumbers(int limit) {
        sums = new int[limit + 1];
        for (int i = 1; i <= limit; i++)
            sums[i] = sumOfProperDivisors(i);
    }

    private static int sumOfProperDivisors(int i) {
        return sumOfFactors(i) - i;
    }

    boolean areAmicable(int a, int b) {
        return a == b ? false : (sums[a] == b) && (sums[b] == a);
    }

    private static int sumOfFactors(int i) {
        return sum(Factors.of(i));
    }

    private static int sum(Set<Integer> set) {
        return set.stream().reduce(0, Integer::sum);
    }
}
