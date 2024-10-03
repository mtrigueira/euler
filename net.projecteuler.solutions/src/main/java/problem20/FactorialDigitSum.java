package problem20;

import utils.DigitNumber;
import utils.Factorial;

import java.math.BigInteger;

public class FactorialDigitSum {
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
