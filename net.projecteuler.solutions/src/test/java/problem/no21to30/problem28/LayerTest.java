package problem.no21to30.problem28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LayerTest {

    @Test
    void lengthOfSideAsInt() {
        assertEquals(1, lengthOfSideAsInt(1));
        assertEquals(3, lengthOfSideAsInt(2));
        assertEquals(5, lengthOfSideAsInt(3));
        assertEquals(7, lengthOfSideAsInt(4));
    }

    private static int lengthOfSideAsInt(int layer) {
        return Layer.of(layer).lengthOfSide().intValueExact();
    }

    @Test
    void sumOfCorners() {
        assertEquals(1, sumOfCornersAsInt(1));
        assertEquals(24, sumOfCornersAsInt(2));
        assertEquals(76, sumOfCornersAsInt(3));
        assertEquals(160, sumOfCornersAsInt(4));
    }

    private static int sumOfCornersAsInt(int layer) {
        return Layer.of(layer).sumOfCorners().intValueExact();
    }
}