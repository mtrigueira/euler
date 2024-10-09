package utils;

public class Palindrome {

    public static final int BASE_TEN = 10;
    public static final int BASE_TWO = 2;

    public static boolean isPalindrome(long i) {
        if (i < 0) return false;
        if (i < 10) return true;

        return isPalindrome(i, BASE_TEN);
    }

    public static boolean isPalindrome(long i, int base) {
        if (base < 2) throw new IllegalArgumentException("Base must be at least 2");
        if (i < 0) return false;
        if (i == 0) return true;

        return isPalindrome(Long.toString(i,base));
    }

    private static boolean isPalindrome(String s) {
        byte[] digits = s.getBytes();
        int lastDigit = digits.length - 1;

        for (int leftDigit = 0; leftDigit < digits.length / 2; leftDigit++)
            if (digits[leftDigit] != digits[lastDigit - leftDigit]) return false;

        return true;
    }
}
