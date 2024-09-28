package problem4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {
    @ParameterizedTest
    @ValueSource(ints = {0,11,121,909,12321})
    void assertIsPalindrome(int i) {
        assertTrue(Palindrome.isPalindrome(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {10,1231,9801})
    void assertIsNotPalindrome(int i) {
        assertFalse(Palindrome.isPalindrome(i));
    }
}