package problem.no31to40;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Problem33Test {
    @Test
    void productOfDenominatorsOfDigitCancellingFractions() {
        assertEquals(Optional.of(100L), Problem33.productOfDenominatorsOfDigitCancellingFractions());
    }
}