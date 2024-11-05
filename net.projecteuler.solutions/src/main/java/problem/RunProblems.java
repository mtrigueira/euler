package problem;

import utils.Stopwatch;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunProblems {
    private RunProblems() {
    }

    public static final String[] O = {};
    public static final int[] SLOW = {12, 14, 23, 32, 39, 41, 47, 51, 58, 60, 68};
    public static final int[] NOT_SLOW = IntStream.range(1, 100)
            .filter(i-> Arrays.stream(SLOW).noneMatch(n -> n == i))
            .toArray();

    public static void main(String[] args) {
        runProblems(SLOW);
    }

    public static void runProblems(int[] problems) {
        Stopwatch stopwatch = Stopwatch.start();

        String results = Arrays.stream(problems)
                .mapToObj(i -> "problem." + groupName(i) + ".Problem" + i)
                .map(RunProblems::runMain
                ).collect(Collectors.joining("\n"));

        System.out.println("Problem,ms,Failed");
        System.out.println(results);
        System.out.println("Total time: " + stopwatch.elapsed() + " ms");
    }

    private static String groupName(int i) {
        int g = (i - 1) / 10;
        return "no" + ((g == 0) ? "" : g) + "1to" + (g + 1) * 10;
    }

    private static String runMain(String s) {
        Stopwatch stopwatch1 = Stopwatch.start();
        boolean failed = true;
        int i = problemNumber(s);
        try {
            Class<?> clazz = Class.forName(s);
            System.out.print(i + " ");
            clazz.getMethod("main", String[].class).invoke(null, (Object) O);
            failed = false;
        } catch (Exception ignored) {
        }
        return (i+"," + stopwatch1.elapsed()+","+(failed?"FAILED":""));
    }

    private static int problemNumber(String s) {
        return Integer.parseInt(s.substring(s.lastIndexOf("Problem") + 7));
    }
}
