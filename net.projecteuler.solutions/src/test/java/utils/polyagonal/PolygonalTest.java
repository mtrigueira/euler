package utils.polyagonal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static utils.BigIntegerConstants.big;

public class PolygonalTest {
    @Test
    void test() {
        assertEquals("Polygonal{sides=100}", new Polygonal(big(100), "").toString());
    }

    @Test
    void testNull() {
        assertThrows(IllegalArgumentException.class, ()-> new Polygonal(null, "").toString());
    }
}
