package problem;

import utils.Stopwatch;

import java.math.BigInteger;

public class Solution {
    private static Stopwatch stopwatch;

    public static void problem(String problem) {
        stopwatch = Stopwatch.start();
        System.out.println(problem);
    }

    public static void solution(int i) {
        solution(Integer.toString(i));
    }

    public static void solution(long i) {
        solution(Long.toString(i));
    }

    public static void solution(BigInteger i) {
        solution(i.toString());
    }

    public static void solution(String s) {
        System.out.println(s);
        stopwatch.println();
    }
}
