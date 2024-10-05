package problem.no1to10.problem4;

public class Palindrome {
    public static boolean isPalindrome(long i) {
        if (i < 0) return false;
        if (i < 10) return true;

        return new Palindrome(i).isPalindrome();
    }

    private final long i;

    private Palindrome(long i) {
        this.i = i;
    }

    private boolean isPalindrome() {
        byte[] digits = Long.toString(i).getBytes();
        int lastDigit = digits.length - 1;

        for (int leftDigit = 0; leftDigit < digits.length / 2; leftDigit++)
            if (digits[leftDigit] != digits[lastDigit - leftDigit]) return false;

        return true;
    }
}
