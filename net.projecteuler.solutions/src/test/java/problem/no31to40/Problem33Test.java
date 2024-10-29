package problem.no31to40;

import org.junit.jupiter.api.Test;
import utils.SimpleFraction;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Problem33Test {
    @Test
    void productOfDenominatorsOfDigitCancellingFractions() {
        assertEquals(Optional.of(100L), Problem33.productOfDenominatorsOfDigitCancellingFractions());
    }

    @Test
    void cancellingDigits16over64() {
        assertEquals(Optional.of(SimpleFraction.of(1, 4)), Problem33.cancellingDigits(16, 64));
    }

    @Test
    void cancellingDigits19over95() {
        assertEquals(Optional.of(SimpleFraction.of(1, 5)), Problem33.cancellingDigits(19, 95));
    }

    @Test
    void cancellingDigit26over65() {
        assertEquals(Optional.of(SimpleFraction.of(2, 5)), Problem33.cancellingDigits(26, 65));
    }

    @Test
    void cancellingDigits49over98() {
        assertEquals(Optional.of(SimpleFraction.of(49, 98)), Problem33.cancellingDigits(49, 98));
    }
}