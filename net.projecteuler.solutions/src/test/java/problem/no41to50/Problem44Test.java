package problem.no41to50;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.polyagonal.Polygonal.TRIANGULAR;

class Problem44Test {
    @Test
    void minimumDifferenceForTriangularPairs() {
        assertEquals(6, Problem44.minimumDifferenceForPolygonalPairs(TRIANGULAR));
    }
}