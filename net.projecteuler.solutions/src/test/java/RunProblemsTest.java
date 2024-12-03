import org.junit.jupiter.api.Test;
import problem.RunProblems;

import static problem.RunProblems.SLOW;

// Very wierd problem, the code coverage instrumentation doesn't seem to work correctly if the test is in the
// same package. It might be something to do with how the instrumentation is added on the fly?
//
// DON'T PUT THIS TEST IN THE SAME PACKAGE AS RUN PROBLEMS viz. problem
//
class RunProblemsTest {
    @Test
    void testRunSlowProblems() {
        // Slow problems may sometimes run fast, but that's not a valid failure assertion
        RunProblems.runProblems(SLOW);
    }

// Since timing is non-determenistic this test is fragile, since a test can sometimes pass or fail
// however in these cases the test should be put into the slow bucket.
    @Test
    void testRunFastProblems() {
        RunProblems.main(new String[] {});
    }
}