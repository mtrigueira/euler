package problem.no31to40;

import static utils.Palindrome.BASE_TWO;
import static utils.Palindrome.isPalindrome;

public class Problem36 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=36
        int sum = 0;
        for (int i = 1; i < 1000000; i++)
            if (isPalindrome(i) && isPalindrome(i, BASE_TWO))
                sum += i;

        System.out.println(sum);
    }
}
