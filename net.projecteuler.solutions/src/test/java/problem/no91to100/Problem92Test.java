package problem.no91to100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem92Test {
    @Test
    void solution2() {
        assertEquals(0, Problem92.solution(2));
    }

    @Test
    void solution3() {
        assertEquals(1, Problem92.solution(3));
    }

    @Test
    void solution4() {
        assertEquals(3, Problem92.solution(5));
    }

    @Test
    void solution10() {
        assertEquals(7, Problem92.solution(10));
    }
}