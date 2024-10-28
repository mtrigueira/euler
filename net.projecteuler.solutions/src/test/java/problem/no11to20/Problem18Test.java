package problem.no11to20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem18Test {

    public static final int TRIANGLE = Problem18.maxPathSum("""
            3
            7 4
            2 4 6""");

    @Test
    void maxPathSum() {
        assertEquals(14, TRIANGLE);
    }


}