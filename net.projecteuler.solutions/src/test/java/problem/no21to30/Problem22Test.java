package problem.no21to30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem22Test {
    @Test
    void forFile() {
        assertEquals(28, Problem22.forFile("InVaLiD_FiLeName.txt"));
    }


}