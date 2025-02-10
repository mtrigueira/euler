package problem;

import java.util.ArrayList;
import java.util.List;

import static problem.Solution.problem;

public class Problem95 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=95
        problem("Amicable chains", () ->
                new Problem95().solution(1_000_000));
    }

    int solution(int limit) {
        ChainMemo longestChain = ChainMemo.NIL;
        ChainMaker chainMaker = new ChainMaker(limit);

        for (int i = 2; i <= limit; i++) {
            ChainMemo chain = chainMaker.chain(i);

            if (chain.length > longestChain.length)
                longestChain = chain;
        }

        return longestChain.smallestMember;
    }

    static class ChainMaker {
        private static int[] sums;
        private final int limit;

        public ChainMaker(int limit) {
            this.limit = limit;
            chain = new ArrayList<>();
            sums = sumOfProperDivisorsForNumbersBetweenOneAnd(limit);
        }

        private int[]  sumOfProperDivisorsForNumbersBetweenOneAnd(int limit) {
            int[] sums = new int[limit + 1];

            for (int j = 2; j <= limit; j++)
                for (int i = j * 2; i <= limit; i += j)
                    sums[i] += j;

            // Only add ones to factor list if there are other factors
            // otherwise it cannot be amicable
            for (int i = 2; i <= limit; i++)
                if (sums[i] > 0)
                    sums[i]++;

            return sums;
        }

        private final List<Integer> chain;

        private int chainLength(int i) {
            int index = chain.indexOf(i);
            if (index >= 0)
                return chain.size();
            return chain.size() - index;
        }

        ChainMemo chain(int i) {
            chain.clear();
            if (i>=sums.length||sums[i] < i) return ChainMemo.NIL;

            int sum = i;

            while (true) {
                chain.add(sum);
                sum = sums[sum];
                if (sum > limit || sum == 0)
                    return ChainMemo.NIL;

                if (chain.contains(sum)) {
                    int index = chain.indexOf(sum);
                    while (index-->0)
                        chain.removeFirst();
                    return new ChainMemo(chainLength(i),smallestMember());
                }
            }
        }

        private int smallestMember() {
            return chain.stream().reduce(Integer.MAX_VALUE,(a,b)->a>b?b:a);
        }
    }

    record ChainMemo(int length, int smallestMember) {
        static final ChainMemo NIL = new ChainMemo(0,-1);
    }
}
