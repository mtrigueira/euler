package utils;

import java.math.BigInteger;

import static utils.operator.BigComparisonOperator.lessThan;

public class Palindrome {

    public static final int BASE_TEN = 10;
    public static final int BASE_TWO = 2;

    public static boolean isPalindrome(BigInteger i) {
        return isPalindrome(i, BASE_TEN);
    }

    public static boolean isPalindrome(BigInteger i, int base) {
        if (base < 2) throw new IllegalArgumentException("Base must be at least 2");
        if (lessThan(i, 0)) return false;
        if (lessThan(i, base)) return true;

        return isPalindrome(i.toString(base));
    }

    private static boolean isPalindrome(String s) {
        byte[] digits = s.getBytes();
        int lastDigit = digits.length - 1;

        for (int leftDigit = 0; leftDigit < digits.length / 2; leftDigit++)
            if (digits[leftDigit] != digits[lastDigit - leftDigit]) return false;

        return true;
    }

    public static boolean isPalindrome(long i) {
        return isPalindrome(i, BASE_TEN);
    }

    public static boolean isPalindrome(long i, int base) {
        return isPalindrome(BigInteger.valueOf(i), base);
    }
}
