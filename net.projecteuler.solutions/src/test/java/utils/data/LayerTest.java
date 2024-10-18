package utils.data;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LayerTest {
    @Test
    void layersInGridOfSizeNxN() {
        assertEquals(OptionalInt.of(1), Layer.layersInGridOfSizeNxN(1));
        assertEquals(OptionalInt.empty(), Layer.layersInGridOfSizeNxN(2));
        assertEquals(OptionalInt.of(2), Layer.layersInGridOfSizeNxN(3));
        assertEquals(OptionalInt.empty(), Layer.layersInGridOfSizeNxN(4));
        assertEquals(OptionalInt.of(3), Layer.layersInGridOfSizeNxN(5));
    }
    
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
}