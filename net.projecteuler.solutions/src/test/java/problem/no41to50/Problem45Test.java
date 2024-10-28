package problem.no41to50;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BigIntegerConstants.big;

class Problem45Test {
    @Test
    void commonToSequencesAfter() {
        assertEquals(Optional.of(big(1)), Problem45.triangularPentagonalAndHexagonalAfter(1));
    }


}