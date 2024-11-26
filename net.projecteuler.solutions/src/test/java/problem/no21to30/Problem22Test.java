package problem.no21to30;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem22Test {
    @Test
    void forFile() {
        assertEquals(67, Problem22.forFile(Stream.of("ANN","BOB")));
    }
}