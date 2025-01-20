package problem.no41to50;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BigIntegerConstants.big;

class Problem46Test {
    @Test
    void goldbachsOtherConjecture() {
        assertEquals(Optional.of(big(5993)), Problem46.goldbachsOtherConjecture(2));
    }
}