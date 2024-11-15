package problem.no31to40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem39Test {
    @Test
    void maximumRightTriangleSolutionsForPerimeterLessThanOrEqualTo() {
            assertEquals(120, Problem39.maximumRightTriangleSolutionsForPerimeterLessThanOrEqualTo(120));
    }

    @Test
    void countSolutionsFor() {
        assertEquals(3, Problem39.countSolutionsFor(120));
    }
}