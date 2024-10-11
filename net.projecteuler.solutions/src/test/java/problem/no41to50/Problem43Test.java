package problem.no41to50;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem43Test {

    @Test
    void isSubDivisible() {
        assertTrue(Problem43.isSubDivisible(List.of(1,4,0,6,3,5,7,2,8,9)));
    }
}