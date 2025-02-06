package problem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {
    private final OutputStream captured = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(captured));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void problem() {
        Solution.problem("This is a test.", () -> "Hello world!");
        assertLinesMatch("This is a test.".lines(), captured.toString().lines());
    }

    @Test
    void problemInt() {
        Solution.problem("This is a test.", () -> 12345);
        assertLinesMatch("This is a test.".lines(), captured.toString().lines());
    }

    @Test
    void problemLong() {
        Solution.problem("This is a test.", () -> 12345L);
        assertLinesMatch("This is a test.".lines(), captured.toString().lines());
    }

    @Test
    void problemBigInteger() {
        Solution.problem("This is a test.", () -> BigInteger.valueOf(12345));
        assertLinesMatch("This is a test.".lines(), captured.toString().lines());
    }

    @Test
    void problemThrows() {
        assertThrows(RuntimeException.class, () -> Solution.problem("This is a test.", () -> {
            throw new Exception("Hello world!");
        }));
    }
}
