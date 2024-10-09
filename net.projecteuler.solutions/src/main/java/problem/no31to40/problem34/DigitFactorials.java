package problem.no31to40.problem34;

import utils.data.DigitNumber;
import utils.operator.Factorial;

import static java.lang.Math.toIntExact;

public class DigitFactorials {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=34
        System.out.println(sumOfNumbersWhereTheSumOfItsDigitsEqualsItself());
    }

    private static int sumOfNumbersWhereTheSumOfItsDigitsEqualsItself() {
        int sum = 0;
        int max = guessMax();

        for (int i = 10; i <= max; i++)
            if (doesSumOfFactorialsOfDigitsEqualsItself(i))
                sum += i;

        return sum;
    }

    private static int guessMax() {
        int j = 1;

        while(Math.pow(10,j)<(double)FACTORIALS[9]*j)
            j++;

        return FACTORIALS[9]*j;
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
