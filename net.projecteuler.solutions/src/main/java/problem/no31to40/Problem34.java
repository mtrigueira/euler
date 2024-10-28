package problem.no31to40;

import utils.data.DigitNumber;
import utils.operator.Factorial;

import java.util.stream.IntStream;

import static java.lang.Math.toIntExact;
import static problem.Solution.problem;

public class Problem34 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=34
        problem("Digit factorials",
                Problem34::sumOfNumbersWhereTheSumOfItsDigitsEqualsItself);
    }

    private static int sumOfNumbersWhereTheSumOfItsDigitsEqualsItself() {
        return IntStream.rangeClosed(10, guessMax())
                .filter(Problem34::doesSumOfFactorialsOfDigitsEqualsItself)
                .sum();
    }

    private static int guessMax() {
        return (int)(FACTORIALS[9] *  Math.ceil(Math.log10(FACTORIALS[9])) + 1);
    }

    static boolean doesSumOfFactorialsOfDigitsEqualsItself(int i) {
        return (sumOfFactorialsOfDigits(i) == i);
    }

    private static final int[] FACTORIALS = makeFactorials();

    private static int[] makeFactorials() {
        int[] factorials = new int[10];

        for (int i = 0; i < factorials.length; i++)
            factorials[i] = toIntExact(Factorial.of(i));

        return factorials;
    }

    private static long sumOfFactorialsOfDigits(int i) {
        long sum = 0;

        for (int d : DigitNumber.of(i).digits())
            sum += FACTORIALS[d];

        return sum;
    }
}
