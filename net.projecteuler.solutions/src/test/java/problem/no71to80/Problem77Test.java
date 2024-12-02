package problem.no71to80;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem77Test {
    @Test
    void numberOfWaysOfWritingAsASumOfPrimes1() {
        assertEquals(0, Problem77.numberOfWaysOfWritingAsASumOfPrimes(1));
    }

    @Test
    void numberOfWaysOfWritingAsASumOfPrimes2() {
        assertEquals(1, Problem77.numberOfWaysOfWritingAsASumOfPrimes(2));
    }

    @Test
    void numberOfWaysOfWritingAsASumOfPrimes4() {
        assertEquals(1, Problem77.numberOfWaysOfWritingAsASumOfPrimes(4));
    }

    @Test
    void numberOfWaysOfWritingAsASumOfPrimes10() {
        assertEquals(5, Problem77.numberOfWaysOfWritingAsASumOfPrimes(10));
    }
}