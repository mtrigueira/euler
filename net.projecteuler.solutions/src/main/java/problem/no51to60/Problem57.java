package problem.no51to60;

import utils.SimpleFraction;

import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.SimpleFraction.*;

public class Problem57 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=57
        problem("Square root convergents");
        solution(countFractions());
    }

    private static int countFractions() {
        SimpleFraction previous = ZERO;
        int  count = 0;
        for (int i = 1; i <= 1000; i++) {
            SimpleFraction f = ONE.divide(TWO.add(previous)).simplify();
            previous = f;
            SimpleFraction rootTwoEstimate = ONE.add(f).simplify();
            if (rootTwoEstimate.numerator().toString().length()>rootTwoEstimate.denominator().toString().length())
                count++;
        }

        return count;
    }
}
