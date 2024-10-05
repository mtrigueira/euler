package problem.no11to20.problem16;

import utils.data.DigitNumber;

import java.math.BigInteger;

public class PowerDigitSum {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=16
        System.out.println(of2ToThe(1000));
    }

    public static int of2ToThe(int i) {
        DigitNumber n = DigitNumber.of(BigInteger.TWO.pow(i).toString());
        return n.sumOfDigits();
    }
}
