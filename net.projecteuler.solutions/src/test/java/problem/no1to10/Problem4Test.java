package problem.no1to10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem4Test {
    @Test
    void forOneDigit() {
        Assertions.assertEquals(9L, Problem4.productOfDigits(1));
    }

    @Test
    void forTwoDigits() {
        Assertions.assertEquals(9009L, Problem4.productOfDigits(2));
    }

    @Test
    void forThreeDigits() {
        Assertions.assertEquals(906609L, Problem4.productOfDigits(3));
    }

    @Test
    void forFourDigits() {
        Assertions.assertEquals(99000099L, Problem4.productOfDigits(4));
    }

    @Test
    void forFiveDigits() {
        Assertions.assertEquals(9966006699L, Problem4.productOfDigits(5));
    }

    @Test
    void forSixDigits() {
        Assertions.assertEquals(999000000999L, Problem4.productOfDigits(6));
    }
}
