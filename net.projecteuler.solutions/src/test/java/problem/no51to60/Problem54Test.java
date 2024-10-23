package problem.no51to60;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem54Test {
    private final String GAMES = """
5H 5C 6S 7S KD 2C 3S 8S 8D TD
5D 8C 9S JS AC 2C 5C 7D 8S QH
2D 9C AS AH AC 3D 6D 7D TD QD
4D 6S 9H QH QC 3D 6D 7H QD QS
2H 2D 4C 4D 4S 3C 3D 3S 9S 9D
            """.trim();
    @Test
    void countPlayer1Wins3of5() {
        assertEquals(3, Problem54.countPlayer1Wins(GAMES.lines()));
    }

    @Test
    void countPlayer1Wins3of4() {
        assertEquals(3, Problem54.countPlayer1Wins(GAMES.lines().skip(1)));
    }

    @Test
    void countPlayer1Wins2of3() {
        assertEquals(2, Problem54.countPlayer1Wins(GAMES.lines().skip(2)));
    }

    @Test
    void countPlayer1Wins2of2() {
        assertEquals(2, Problem54.countPlayer1Wins(GAMES.lines().skip(3)));
    }
}