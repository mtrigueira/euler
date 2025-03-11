package problem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {
    public static final String BANNER = "This is a test.";
    private final OutputStream captured = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(captured, false, StandardCharsets.UTF_8));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void problem() {
        Solution.problem(BANNER, () -> "Hello world!");
        assertSolutionBanner(captured);
    }

    private static void assertSolutionBanner(Object actual) {
        Assertions.assertLinesMatch(
                Arrays.asList(BANNER.split("%n".formatted())),
                Arrays.asList(actual.toString().split("%n".formatted()))
        );
    }

    @Test
    void problemInt() {
        Solution.problem(BANNER, () -> 12345);
        assertSolutionBanner(captured);
    }

    @Test
    void problemLong() {
        Solution.problem(BANNER, () -> 12345L);
        assertSolutionBanner(captured);
    }

    @Test
    void problemBigInteger() {
        Solution.problem(BANNER, () -> BigInteger.valueOf(12345));
        assertSolutionBanner(captured);
    }

    @Test
    void problemThrows() {
        assertThrows(RuntimeException.class, () -> Solution.problem(BANNER, () -> {
            throw new Exception("Hello world!");
        }));
    }
}
