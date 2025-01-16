package problem.no21to30.library22;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.Score;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreTest {
    @ParameterizedTest(name = "score({0},{1}) = {2}")
    @CsvSource({
            "1,A,1",
            "2,Z,52",
            "3,ANN,87",
            "4,COLIN,212"
    })
    void nameOfIndex1(int index, String name, int score) {
        assertEquals(score, Score.nameScore(index,name));
    }

    @Test
    void of() {
        assertEquals(5, Score.of(new Scanner("A,B").useDelimiter(",").tokens()));
    }
}