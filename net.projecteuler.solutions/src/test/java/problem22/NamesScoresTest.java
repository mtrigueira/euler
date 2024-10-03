package problem22;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NamesScoresTest {
    @ParameterizedTest
    @CsvSource({
            "1,A,1",
            "2,Z,52",
            "3,ANN,87",
            "4,COLIN,212"
    })
    void nameScoreIndex1(int index, String name, int score) {
        assertEquals(score, NamesScores.nameScore(index,name));
    }

    @ParameterizedTest
    @CsvSource({
            "A,1",
            "Z,26",
            "ANN,29",
            "COLIN,53"
    })
    void nameWorth(String name, int worth) {
        assertEquals(worth, NamesScores.nameWorth(name));
    }

    @ParameterizedTest
    @CsvSource({
            "A,1",
            "Z,26"
    })
    void scoreChar(char c, int score) {
        assertEquals(score, NamesScores.scoreChar(c));
    }

    @Test
    void forFile() {
        assertEquals(871198282, NamesScores.forFile("0022_names.txt"));
    }

    @Test
    void forFileNoFound() {
        assertThrows(NullPointerException.class, () -> NamesScores.forFile("InVaLiD_FiLeName.txt"));
    }
}