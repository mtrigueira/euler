import org.junit.jupiter.api.Test;
import problem.RunProblems;

import static problem.RunProblems.DO_NOT_SKIP_ANY;
import static problem.RunProblems.SKIP_SLOW;

// Very wierd problem, the code coverage instrumentation doesn't seem to work correctly if the test is in the
// same package.
//
// DONT PUT THIS TEST IN THE SAME PACKAGE AS RUN PROBLEMS viz. problem
class RunProblemsTest {
    @Test
    void testRunProblems() {
        RunProblems.runProblems(DO_NOT_SKIP_ANY);
    }

    @Test
    void testRunFastProblems() {
        RunProblems.runProblems(SKIP_SLOW);
    }
}