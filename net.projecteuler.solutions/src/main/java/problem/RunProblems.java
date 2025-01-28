package problem;

import utils.Stopwatch;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunProblems {
    public static void main(String[] args) {
        runProblems();
    }

    private static final String[] O = {};

    public static void runProblems() {
        Stopwatch stopwatch = Stopwatch.start();

        String results = IntStream.rangeClosed(1, 101)
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
        String error = "";
        int i = problemNumber(s);
        try {
            Class<?> clazz = Class.forName(s);
            System.out.print(i + " ");
            Method main = clazz.getMethod("main", String[].class);

            main.invoke(null, (Object) O);

        } catch (ReflectiveOperationException e) {
            error = e.getMessage();
        }

        return (i + "," + stopwatch1.elapsed() + "," + error);
    }

    private static int problemNumber(String s) {
        return Integer.parseInt(s.substring(s.lastIndexOf("Problem") + 7));
    }

    private RunProblems() {
    }
}
