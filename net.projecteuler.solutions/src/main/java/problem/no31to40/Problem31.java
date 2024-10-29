package problem.no31to40;

import java.util.stream.IntStream;

import static problem.Solution.problem;

public class Problem31 {
     private Problem31() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=31
        problem("Coin sums",
        () -> countWaysToMakeUsingAnyNumberOfCoins(200));
    }

    private static final short[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};

    static long countWaysToMakeUsingAnyNumberOfCoins(int target) {
        if (target <= 0) return 0;

        return getCount(COINS.length - 1, target);
    }

    private static long getCount(int coin, int target) {
        if (coin < 0) return 0;
        int coinAmount = COINS[coin];

        long count = IntStream.iterate(0, sum -> sum < target, sum -> sum + coinAmount)
                .mapToLong(sum -> getCount(coin - 1, target - sum))
                .sum();

        if (target % coinAmount == 0)
            count++;

        return count;
    }
}