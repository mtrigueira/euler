package problem4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestPalindromeProductTest {
    @Test
    void forOneDigit() {
        assertEquals(9L,LargestPalindromeProduct.productOfDigits(1));
    }

    @Test
    void forTwoDigits() {
        assertEquals(9009L,LargestPalindromeProduct.productOfDigits(2));
    }

    @Test
    void forThreeDigits() {
        assertEquals(906609L,LargestPalindromeProduct.productOfDigits(3));
    }

    @Test
    void forFourDigits() {
        assertEquals(99000099L,LargestPalindromeProduct.productOfDigits(4));
    }

    @Test
    void forFiveDigits() {
        assertEquals(9966006699L,LargestPalindromeProduct.productOfDigits(5));
    }

    @Test
    void forSixDigits() {
        assertEquals(999000000999L,LargestPalindromeProduct.productOfDigits(6));
    }
}
