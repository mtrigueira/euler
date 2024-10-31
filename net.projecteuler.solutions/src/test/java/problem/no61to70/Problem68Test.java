package problem.no61to70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem68Test {
    @Test
    void maximumNgonString() {
        assertEquals("432621513", Problem68.maximumNgonString(3, 9));
    }
}