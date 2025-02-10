package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem86Test {
    @Test
    void shortestRouteAlongCuboid0() {
        assertEquals(0.0, Problem86.Cube.of(0,0,0).shortestRoute());
    }

    @Test
    void shortestRouteAlongCuboid1() {
        assertEquals(2.23606797749979, Problem86.Cube.of(1,1,1).shortestRoute());
    }

    @Test
    void shortestRouteAlongCuboid() {
        assertEquals(10.0, Problem86.Cube.of(3,5,6).shortestRoute());
    }

    @Test
    void distinctCuboids100() {
        assertEquals(2060, Problem86.countOfShortestIntegerPathsOfCuboidsFromNbyMbyMUpToMbyMbyM(1, 100));
    }

    @Test
    void distinctCuboids99() {
        assertEquals(1975, Problem86.countOfShortestIntegerPathsOfCuboidsFromNbyMbyMUpToMbyMbyM(1, 99));
    }

    @Test
    void solution() {
        assertEquals(100, Problem86.solution(2_000));
    }
}