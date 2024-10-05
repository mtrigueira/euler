package utils.sequence.arithmetic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenFibonacciTest {
    private static EvenFibonnacciSequence f;
    @BeforeAll
    static void setUp() {
        f = new EvenFibonnacciSequence();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 8, 34, 144, 610, 2584, 10946, 46368, 196418, 832040, 3524578})
    void evenFibonacciTest(int i) {
        assertEquals(i, f.next().longValueExact());
    }
}
