package problem;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem45Test {
    @Test
    void commonToSequencesAfter() {
        assertEquals(Optional.of(1L), Problem45.triangularPentagonalAndHexagonalAfter(1));
    }


}