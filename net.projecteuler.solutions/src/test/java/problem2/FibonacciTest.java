package problem2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {
    private static FibonnacciSequence f;
    @BeforeAll
    static void setUp() {
        f = new FibonnacciSequence();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89})
    void fibonnacciTest(int i) {
        assertEquals(i, f.next());
    }
}
