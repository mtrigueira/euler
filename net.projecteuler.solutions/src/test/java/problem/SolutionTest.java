package problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final OutputStream captured = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(captured));
    }

    @Test
    void problem() {
        Solution.problem("This is a test.");
        assertLinesMatch("This is a test.\n".lines(), captured.toString().lines());
    }

    @Test
    void problemInt() {
        Solution.problem("This is a test.");
        Solution.solution(12345);
        assertLinesMatch("This is a test.\n12345\nTime taken: [1-9]*[0-9] ms\n".lines(), captured.toString().lines());
    }

    @Test
    void problemLong() {
        Solution.problem("This is a test.");
        Solution.solution(12345L);
        assertLinesMatch("This is a test.\n12345\nTime taken: [1-9]*[0-9] ms\n".lines(), captured.toString().lines());
    }

    @Test
    void problemBigInteger() {
        Solution.problem("This is a test.");
        Solution.solution(BigInteger.valueOf(12345));
        assertLinesMatch("This is a test.\n12345\nTime taken: [1-9]*[0-9] ms\n".lines(), captured.toString().lines());
    }
}
