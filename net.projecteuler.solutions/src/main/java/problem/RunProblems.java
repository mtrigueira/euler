package problem;

import utils.Stopwatch;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunProblems {
    public static final String[] O = {};
    public static final int[] SLOW = {60};
    public static final int[] NOT_SLOW = IntStream.range(1, 100)
            .filter(i -> Arrays.stream(SLOW).noneMatch(n -> n == i))
            .toArray();
    public static final int TOO_SLOW_THRESHOLD_MS = 1000;
    public static boolean tooSlow = false;
    private static boolean anyFailed;

    private RunProblems() {
    }

    public static void main(String[] args) {
        runProblems(SLOW);
    }

    public static boolean runProblems(int[] problems) {
        tooSlow = false;
        anyFailed = false;
        Stopwatch stopwatch = Stopwatch.start();

        String results = Arrays.stream(problems)
                .mapToObj(i -> "problem." + groupName(i) + ".Problem" + i)
                .map(RunProblems::runMain
                ).collect(Collectors.joining("\n"));

        System.out.println("Problem,ms,Failed");
        System.out.println(results);
        System.out.println("Total time: " + stopwatch.elapsed() + " ms");
        
        if(anyFailed) throw new RuntimeException("Problems failed");

        return tooSlow;
    }

    private static String groupName(int i) {
        int g = (i - 1) / 10;
        return "no" + ((g == 0) ? "" : g) + "1to" + (g + 1) * 10;
    }

    private static String runMain(String s) {
        Stopwatch stopwatch1 = Stopwatch.start();
        boolean failed = false;
        int i = problemNumber(s);
        try {
            Class<?> clazz = Class.forName(s);
            System.out.print(i + " ");
            Method main = clazz.getMethod("main", String[].class);
            failed = true;
            main.invoke(null, (Object) O);
            failed = false;
        } catch (Exception ignored) {
        }
        if(stopwatch1.elapsed() > TOO_SLOW_THRESHOLD_MS) {
            System.err.println("Problem " + i + " took " + stopwatch1.elapsed() + " ms");
            tooSlow = true;
        }
        if(failed)
            anyFailed = true;
        return (i + "," + stopwatch1.elapsed() + "," + (failed ? "FAILED" : ""));
    }

    private static int problemNumber(String s) {
        return Integer.parseInt(s.substring(s.lastIndexOf("Problem") + 7));
    }
}
