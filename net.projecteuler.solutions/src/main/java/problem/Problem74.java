package problem;

import utils.operator.Factorial;

import java.util.ArrayList;
import java.util.List;

import static problem.Solution.problem;

public class Problem74 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=74
        problem("Digit factorial chains", Problem74::solution);
    }

    private static final int[] digitFactorials = calculateDigitFactorials();
    final int[] chainLength;
    private final int limit;
    private final int[] sumOfDigitFactorials;

    Problem74(int limit) {
        this.limit = limit;
        sumOfDigitFactorials = new int[limit + 1];
        for (int i = 0; i <= limit; i++)
            sumOfDigitFactorials[i] = sumOfFactorialsOfDigits(i);

        chainLength = new int[limit + 1];
        calculateChainLengths();
    }

    private static int solution() {
        Problem74 problem74 = new Problem74(1_000_000);
        int count = 0;

        for (int k : problem74.chainLength)
            if (k == 60)
                count++;

        return count;
    }

    private static int[] calculateDigitFactorials() {
        int[] digitFactorials = new int[10];

        for (int i = 0; i <= 9; i++)
            digitFactorials[i] = (int) Factorial.of(i);

        return digitFactorials;
    }

    private static int sumOfFactorialsOfDigits(int i) {
        int sum = 0;
        String s = Integer.toString(i);

        for (int j = 0; j < s.length(); j++)
            sum += digitFactorials[s.charAt(j) - '0'];

        return sum;
    }

    private void calculateChainLengths() {
        List<Integer> chain = new ArrayList<>(60);
        int i = -1;
        while (i < limit) {
            i++;
            if (noChainLengthHasBeenCalculated(i)) {
                chain.clear();
                int found = buildChainAndReturnLastLink(i, chain);
                if (isWithinLimit(found))
                    populateChainWithLengths(found, chain);
            }
        }
    }

    private boolean isWithinLimit(int found) {
        return found <= limit;
    }

    private boolean noChainLengthHasBeenCalculated(int i) {
        return chainLength[i] == 0;
    }

    private void populateChainWithLengths(int found, List<Integer> chain) {
        int len = chainLength(found, chain);

        for (int j = 0; j < chain.size(); j++) {
            int link = chain.get(j);
            if (isWithinLimit(link))
                chainLength[link] = len - j;
        }
    }

    private int chainLength(int found, List<Integer> chain) {
        return chainLength[found] + chain.size();
    }

    private int buildChainAndReturnLastLink(int i, List<Integer> chain) {
        int next;

        for (next = i; !(chain.contains(next) || hasAChainLength(next)); next = getNext(next))
            chain.add(next);

        return next;
    }

    private boolean hasAChainLength(int next) {
        return next <= limit && chainLength[next] != 0;
    }

    private int getNext(int next) {
        if (isWithinLimit(next))
            next = sumOfDigitFactorials[next];
        else
            next = sumOfFactorialsOfDigits(next);

        return next;
    }
}
