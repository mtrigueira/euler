package problem.no21to30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Problem22Test {
    @Test
    void forFile() {
        assertEquals(871198282, Problem22.forFile("/0022_names.txt"));
    }

    @Test
    void forFileNoFound() {
        assertThrows(NullPointerException.class, () -> Problem22.forFile("InVaLiD_FiLeName.txt"));
    }
}