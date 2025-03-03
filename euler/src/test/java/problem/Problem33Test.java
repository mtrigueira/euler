package problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.SimpleFraction;
import utils.Tupple;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Problem33Test {
    @Test
    void productOfDenominatorsOfDigitCancellingFractions() {
        Optional<Long> actual = Problem33.productOfDenominatorsOfDigitCancellingFractions();
        assertEquals(Optional.of(100L), actual);
    }

    @ParameterizedTest(name = "f({1}) = {0}")
    @CsvSource({
            "1/4,16/64",
            "1/5,19/95",
            "2/5,26/65",
            "49/98,49/98"
    })
    void cancellingDigitsNOverD(String expectedString, String givenString) {
        SimpleFraction expected = SimpleFraction.parseSimpleFraction(expectedString);
        Tupple<BigInteger> given = SimpleFraction.parse(givenString);
        int n = given.left().intValueExact();
        int d = given.right().intValueExact();

        SimpleFraction actual = Problem33.cancellingDigits(n, d).orElseThrow();

        assertEquals(expected, actual);
    }
}