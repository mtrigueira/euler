package problem;

import utils.Stopwatch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RunProblems {
    public static final String[] O = {};
    public static final Integer[] SKIP_SLOW = {5, 10, 12, 14, 23, 24, 32, 39, 41, 43, 47, 51, 58, 60};
    public static final Integer[] DO_NOT_SKIP_ANY = {};

    public static void main(String[] args) {
        runProblems(SKIP_SLOW);
    }

    public static void runProblems(Integer[] skip) {
        List<String> problems = IntStream.range(1, 100)
                .filter(i-> Arrays.stream(skip).noneMatch(n -> n == i))
                .mapToObj(i -> "problem." + groupName(i) + ".Problem" + i).toList();

        Stopwatch stopwatch = Stopwatch.start();
        problems.forEach(RunProblems::runMain);
        stopwatch.println();
    }

    private static String groupName(int i) {
        int g = (i - 1) / 10;
        return "no" + ((g == 0) ? "" : g) + "1to" + (g + 1) * 10;
    }

    private static void runMain(String s) {
        int i = problemNumber(s);
        try {
            Class<?> clazz = Class.forName(s);
            System.out.print(i + " ");
            clazz.getMethod("main", String[].class).invoke(null, (Object) O);
        } catch (ClassNotFoundException ignored) {
        } catch (Exception e) {
            System.err.println(s);
            e.printStackTrace();
        }
    }

    private static int problemNumber(String s) {
        return Integer.parseInt(s.substring(s.lastIndexOf("Problem") + 7));
    }
}
