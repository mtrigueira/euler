package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Palindrome.BASE_TWO;

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

    @ParameterizedTest
    @ValueSource(ints = {0b101,0b11011,0b1011001101})
    void assertIsPalindromeBinary(int i) {
        assertTrue(Palindrome.isPalindrome(i, BASE_TWO));
    }

    @ParameterizedTest
    @ValueSource(ints = {0b10,0b110,0b11101111})
    void assertIsNotPalindromeBinary(int i) {
        assertFalse(Palindrome.isPalindrome(i, BASE_TWO));
    }
}