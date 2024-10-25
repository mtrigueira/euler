package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.BigIntegerConstants.big;

class ContinuedFractionTest {
    @Test
    void convergentsOfE() {
        ContinuedFraction e = ContinuedFraction.e();
        assertEquals(big(2), e.at(0));
        assertEquals(big(1), e.at(1));
        assertEquals(big(2), e.at(2));
        assertEquals(big(1), e.at(3));
        assertEquals(big(1), e.at(4));
        assertEquals(big(4), e.at(5));
    }
}