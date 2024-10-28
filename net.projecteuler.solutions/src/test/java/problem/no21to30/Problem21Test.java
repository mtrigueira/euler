package problem.no21to30;

import org.junit.jupiter.api.Test;
import utils.Amicable;

import static org.junit.jupiter.api.Assertions.*;

class Problem21Test {
    @Test
    void below220() {
        assertTrue(new Amicable(221).hasAmicable(220));
    }

    @Test
    void sumBelow220() {
        assertEquals(0, Problem21.below(220));
    }
}