package problem.no1to10;

import utils.Palindrome;

import static problem.Solution.problem;

public class Problem4 {
     private Problem4() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=4
        problem("Largest palindrome product",
                () -> productOfDigits(3));
    }

    static long productOfDigits(int digits) {
        if (digits < 1) throw new RuntimeException("Digits must be greater than 0");
        int highestMultiplier = (int) (Math.pow(10, digits) - 1);
        long maxPalindrome = 0;

        for (long i = highestMultiplier; i * i > maxPalindrome; i--)
            for (long j = i; j > 0; j--) {
                if (i * j <= maxPalindrome) break;
                if (Palindrome.isPalindrome(i * j))
                    maxPalindrome = i * j;
            }

        return maxPalindrome;
    }
}
