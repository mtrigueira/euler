package problem.no31to40;

import utils.Palindrome;

import java.util.stream.IntStream;

import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.Palindrome.BASE_TWO;
import static utils.Palindrome.isPalindrome;

public class Problem36 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=36
        problem("Double-base palindromes");
        solution(
                IntStream.rangeClosed(1, 1000000)
                        .filter(Palindrome::isPalindrome)
                        .filter(i -> isPalindrome(i, BASE_TWO))
                        .sum()
        );
    }
}
