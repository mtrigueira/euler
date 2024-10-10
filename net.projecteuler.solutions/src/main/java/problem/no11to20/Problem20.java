package problem.no11to20;

import utils.data.DigitNumber;
import utils.operator.Factorial;

import java.math.BigInteger;

public class Problem20 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=20
        System.out.println(sumOfFactorial(100));
    }

    public static int sumOfFactorial(int i) {
        return factorialOf(i).sumOfDigits();
    }

    private static DigitNumber factorialOf(int i) {
        return DigitNumber.of(Factorial.ofBig(BigInteger.valueOf(i)).toString());
    }
}
