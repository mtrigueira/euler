package problem;

import utils.Palindrome;

import java.util.stream.IntStream;

import static problem.Solution.problem;
import static utils.Palindrome.BASE_TWO;
import static utils.Palindrome.isPalindrome;

public class Problem36 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=36
        problem("Double-base palindromes",
                () ->
                        sumOfDoubleBasePalindromesBelow(1000000)
        );
    }

    static int sumOfDoubleBasePalindromesBelow(int endInclusive) {
        return IntStream.rangeClosed(1, endInclusive)
                .filter(Palindrome::isPalindrome)
                .filter(i -> isPalindrome(i, BASE_TWO))
                .sum();
    }

    private Problem36() {}
}
