package utils.sequence.arithmetic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciSequenceTest {
    private static FibonacciSequence f;
    @BeforeAll
    static void setUp() {
        f = new FibonacciSequence();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89})
    void fibonacciTest(int i) {
        assertEquals(i, f.next().longValueExact());
    }
}
