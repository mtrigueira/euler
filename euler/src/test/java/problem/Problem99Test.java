package problem;

import org.junit.jupiter.api.Test;
import utils.FileUtils;

import static org.junit.jupiter.api.Assertions.*;

class Problem99Test {
    @Test
    void greaterThan() {
        assertLeftGreaterThanRight( "2,1\n1,1");
        assertLeftGreaterThanRight("3,1\n2,1");
        assertLeftGreaterThanRight("2,2\n2,1");
    }

    private static void assertLeftGreaterThanRight(String numbers) {
        assertEquals(1, Problem99.solution(FileUtils.concat(null, numbers)));
    }
}