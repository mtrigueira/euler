package problem.no31to40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static problem.no31to40.Problem31.countWaysToMakeUsingAnyNumberOfCoins;

class Problem31Test {
    @Test
    public void testSolution0() {
        assertEquals(0, countWaysToMakeUsingAnyNumberOfCoins(0));
    }

    @Test
    public void testSolution1() {
        assertEquals(1, countWaysToMakeUsingAnyNumberOfCoins(1));
    }

    @Test
    public void testSolution2() {
        assertEquals(2, countWaysToMakeUsingAnyNumberOfCoins(2));
    }

    @Test
    public void testSolution3() {
        assertEquals(2, countWaysToMakeUsingAnyNumberOfCoins(3));
    }

    @Test
    public void testSolution4() {
        assertEquals(3, countWaysToMakeUsingAnyNumberOfCoins(4));
    }

    @Test
    public void testSolution5() {
        assertEquals(4, countWaysToMakeUsingAnyNumberOfCoins(5));
    }

    @Test
    public void testSolution6() {
        assertEquals(5, countWaysToMakeUsingAnyNumberOfCoins(6));
    }

    @Test
    public void testSolution7() {
        assertEquals(6, countWaysToMakeUsingAnyNumberOfCoins(7));
    }


}