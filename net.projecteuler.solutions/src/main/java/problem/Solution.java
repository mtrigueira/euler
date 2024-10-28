package problem;

import utils.Stopwatch;

import java.util.concurrent.Callable;

public class Solution {
    private Solution() {
    }

    public static void problem(String problem, Callable<Object> solution) {
        Stopwatch stopwatch;
        stopwatch = Stopwatch.start();
        System.out.println(problem);
        try {
            System.out.println(solution.call().toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        stopwatch.println();
    }
}
