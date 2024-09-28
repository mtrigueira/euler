package problem4;

public class LargestPalindromeProduct {
    public static long productOfDigits(int digits) {
        if (digits<1) throw new RuntimeException("Digits must be greater than 0");
        int highestMultiplier = (int)(Math.pow(10,digits)-1);
        long maxPalindrome = 0;

        for(long i=highestMultiplier; i>0; i--) {
            if (i * i <= maxPalindrome) break;
            for (long j = i; j > 0; j--) {
                if (i * j <= maxPalindrome) break;
                if (Palindrome.isPalindrome(i * j))
                    maxPalindrome = i * j;
            }
        }

        return maxPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(productOfDigits(3));
    }
}
