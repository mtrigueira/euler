package problem.no61to70;

import utils.operator.Factorial;

import java.util.ArrayList;
import java.util.List;

import static problem.Solution.problem;

public class Problem74 {
    private static final int[] digitFactorials = calculateDigitFactorials();

    public static void main(String[] args) {
        // https://projecteuler.net/problem=74
        problem("Digit factorial chains", Problem74::solution);
    }

    private static int solution() {
        int[] chainLength = calculateChainLengths(1_000_000);
        int count = 0;

        for (int k : chainLength)
            if (k == 60)
                count++;

        return count;
    }

    static int[] calculateChainLengths(int limit) {
        int[] sumOfDigitFactorials = new int[limit + 1];
        for (int i = 0; i <= limit; i++)
            sumOfDigitFactorials[i] = sumOfFactorialsOfDigits(i);

        List<Integer> chain = new ArrayList<>(60);
        int[] chainLength = new int[limit + 1];
        int i = -1;
        while (i < limit) {
            i++;
            if (chainLength[i] == 0) {
                chain.clear();
                int next = i;

                while (!chain.contains(next)) {
                    chain.add(next);
                    if (next <= limit)
                        next = sumOfDigitFactorials[next];
                    else
                        next = sumOfFactorialsOfDigits(next);
                }

                chainLength[i] = chain.size();
            }
        }

        return chainLength;
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
}
