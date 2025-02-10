package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem84Test {
    @Test
    void test() {
        assertEquals("102400", new Problem84(6).solution());
    }
}