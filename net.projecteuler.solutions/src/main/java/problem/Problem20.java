package problem;

import utils.data.DigitNumber;
import utils.operator.Factorial;

import static problem.Solution.problem;

public class Problem20 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=20
        problem("Factorial digit sum",
                () -> sumOfFactorial(100));
    }

    public static int sumOfFactorial(int i) {
        return factorialOf(i).sumOfDigits();
    }

    private static DigitNumber factorialOf(int i) {
        return DigitNumber.of(Factorial.ofBig(i));
    }

    private Problem20() {}
}
