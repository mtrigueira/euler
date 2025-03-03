package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem65Test {
    @Test
    void convergentsOfE10() {
        assertEquals(17, Problem65.convergentsOfE(10));
    }

    @Test
    void convergentsOfE9() {
        assertEquals(13, Problem65.convergentsOfE(9));
    }


}