package problem;

import utils.Stopwatch;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunProblems {
    public static void main(String[] args) {
        if (runProblems(FAST)) throw new RuntimeException("Slow test in FAST bucket");
    }

    public static final int[] SLOW = {78};
    public static final int[] FAST = IntStream.range(1, 100)
            .filter(i -> Arrays.stream(SLOW).noneMatch(n -> n == i))
            .toArray();
    private static final String[] O = {};
    private static final int TOO_SLOW_THRESHOLD_MS = 1000;
    private static final List<Integer> failed = new ArrayList<>();
    private static boolean tooSlow = false;

    public static boolean runProblems(int[] problems) {
        tooSlow = false;
        failed.clear();
        Stopwatch stopwatch = Stopwatch.start();

        String results = Arrays.stream(problems)
                .mapToObj(i -> "problem." + groupName(i) + ".Problem" + i)
                .map(RunProblems::runMain
                ).collect(Collectors.joining("\n"));

        System.out.println("Problem,ms,Failed");
        System.out.println(results);
        System.out.println("Total time: " + stopwatch.elapsed() + " ms");

        if (!failed.isEmpty()) throw new RuntimeException("Problems failed. " + failed);

        return tooSlow;
    }

    private static String groupName(int i) {
        int g = (i - 1) / 10;
        return "no" + ((g == 0) ? "" : g) + "1to" + (g + 1) * 10;
    }

    private static String runMain(String s) {
        Stopwatch stopwatch1 = Stopwatch.start();
        boolean failedFlag = false;
        int i = problemNumber(s);
        try {
            Class<?> clazz = Class.forName(s);
            System.out.print(i + " ");
            Method main = clazz.getMethod("main", String[].class);
            failedFlag = true;
            main.invoke(null, (Object) O);
            failedFlag = false;
        } catch (Exception ignored) {
        }
        if (stopwatch1.elapsed() > TOO_SLOW_THRESHOLD_MS) {
            System.err.println("Problem " + i + " took " + stopwatch1.elapsed() + " ms");
            tooSlow = true;
        }
        if (failedFlag)
            failed.add(i);

        return (i + "," + stopwatch1.elapsed() + "," + (failedFlag ? "FAILED" : ""));
    }

    private static int problemNumber(String s) {
        return Integer.parseInt(s.substring(s.lastIndexOf("Problem") + 7));
    }

    private RunProblems() {
    }
}
