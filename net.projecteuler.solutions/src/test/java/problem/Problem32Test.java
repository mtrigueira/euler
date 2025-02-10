package problem;

import org.junit.jupiter.api.Test;
import utils.sequence.given.CombinationSequence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem32Test {
    @Test
    void squish() {
        assertEquals(1L, Problem32.squishTill(1234L, 0));
        assertEquals(12L, Problem32.squishTill(1234L, 1));
        assertEquals(234L, Problem32.squishFrom(1234L, 1));
        assertEquals(1234L, Problem32.squishFrom(1234L, 0));
    }

    @Test
    void test() {
        assertEquals(0, Problem32.getSum(new CombinationSequence<>(List.of(1L, 2L, 3L, 4L), Problem32::concat)));
    }
}