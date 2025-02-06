package problem;

import utils.Stopwatch;

import java.lang.reflect.Method;
import java.util.stream.IntStream;

public class RunProblems {
    public static void main(String[] args) {
        runProblems();
    }

    private static final String[] O = {};

    public static void runProblems() {
        Stopwatch stopwatch = Stopwatch.start();

        IntStream.rangeClosed(1, 101)
                .mapToObj(i -> "problem." + groupName(i) + ".Problem" + i)
                .forEach(RunProblems::runMain);

        System.out.println("Total time: " + stopwatch.elapsed() + " ms");
    }

    private static String groupName(int i) {
        int g = (i - 1) / 10;
        return "no" + ((g == 0) ? "" : g) + "1to" + (g + 1) * 10;
    }

    private static String runMain(String s) {
        String error = "";

        int i = problemNumber(s);
        try {
            Class<?> clazz = Class.forName(s);

            Method main = clazz.getMethod("main", String[].class);

            Stopwatch stopwatch;
            stopwatch = Stopwatch.start();
            System.out.print(i + ". [");
            main.invoke(null, (Object) O);
            System.out.print("](net.projecteuler.solutions/src/main/java/" + s.replaceAll("\\.", "/") + ".java) ");
            stopwatch.println();
        } catch (ReflectiveOperationException e) {
            error = e.getMessage();
        }

        return Solution.answer == null ? error : Solution.answer.toString();
    }

    private static int problemNumber(String s) {
        return Integer.parseInt(s.substring(s.lastIndexOf("Problem") + 7));
    }

    private RunProblems() {
    }
}
