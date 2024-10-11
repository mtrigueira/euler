package problem.no21to30;

import utils.DigitPower;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem30 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=30
        problem("Digit fifth powers");
        solution(sumWhereDigitPowersSumEqualsNumberFor(5));
    }

    static long sumWhereDigitPowersSumEqualsNumberFor(int exponent) {
        DigitPower digitPower = DigitPower.forExponent(exponent);
        long allSum = 0;

        long n = digitPower.getMaxPossibleSum();
        for (int i = 2; i <= n; i++)
            if (digitPower.sumOfDigitPowersFor(i) == i)
                allSum += i;

        return allSum;
    }
}

