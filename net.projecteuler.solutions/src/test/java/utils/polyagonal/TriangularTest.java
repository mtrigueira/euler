package utils.polyagonal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.polyagonal.Polygonal.TRIANGULAR;

class TriangularTest {
    private static final AtomicInteger n = new AtomicInteger(1);

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153, 171, 190, 210, 231})
    void atPosition(int x) {
        assertEquals(x, TRIANGULAR.at(n.getAndIncrement()));
    }
}