package utils.sequence.arithmetic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.polyagonal.Polygonal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PentagonalSequenceTest {
    private static PolygonalSequence f;

    @BeforeAll
    static void setUp() {
        f = new PolygonalSequence(Polygonal.PENTAGONAL);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 12, 22, 35, 51, 70, 92, 117, 145})
    void pentagonalSequenceTest(int i) {
        assertEquals(i, f.next().longValueExact());
    }
}