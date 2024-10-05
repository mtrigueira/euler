package problem.no21to30.problem22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NamesScoresTest {


    @Test
    void forFile() {
        assertEquals(871198282, NamesScores.forFile("0022_names.txt"));
    }

    @Test
    void forFileNoFound() {
        assertThrows(NullPointerException.class, () -> NamesScores.forFile("InVaLiD_FiLeName.txt"));
    }
}