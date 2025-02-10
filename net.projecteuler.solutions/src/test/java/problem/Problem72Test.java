package problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem72Test {

    @Test
    void orderedFractionToLeftOfWhere() {
        Assertions.assertEquals(21, Problem72.orderedFractionToLeftOfWhere(8));
    }
}