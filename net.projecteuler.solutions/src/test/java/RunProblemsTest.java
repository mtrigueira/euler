import org.junit.jupiter.api.Test;
import problem.RunProblems;

import static problem.RunProblems.NOT_SLOW;

// Very wierd problem, the code coverage instrumentation doesn't seem to work correctly if the test is in the
// same package. It might be something to do with how the instrumentation is added on the fly?
//
// DON'T PUT THIS TEST IN THE SAME PACKAGE AS RUN PROBLEMS viz. problem
class RunProblemsTest {
    @Test
    void testRunProblems() {
        RunProblems.main(new String[] {});
    }

    @Test
    void testRunFastProblems() {
        RunProblems.runProblems(NOT_SLOW);
    }
}