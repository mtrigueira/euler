package problem;

import java.util.concurrent.Callable;

public class Solution {
    static Object answer;

    public static void problem(String problem, Callable<Object> solution) {
        try {
            System.out.print(problem);
            answer = solution.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Solution() {
    }
}
