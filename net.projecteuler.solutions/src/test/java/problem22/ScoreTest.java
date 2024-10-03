package problem22;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void score() {
        assertEquals(5, new Score().score(new Scanner("A,B").useDelimiter(",").tokens()));
    }
}