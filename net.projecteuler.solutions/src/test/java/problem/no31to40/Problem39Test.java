package problem.no31to40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem39Test {

    @Test
    void maximumRightTriangleSolutionsForPerimeterLessThanOrEqualTo() {
            assertEquals(168, Problem39.maximumRightTriangleSolutionsForPerimeterLessThanOrEqualTo(170));
    }

    @Test
    void countSolutionsFor() {
        assertEquals(3, Problem39.countSolutionsFor(120));
    }
}