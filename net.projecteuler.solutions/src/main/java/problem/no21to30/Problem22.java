package problem.no21to30;

import utils.FileUtils;
import utils.Score;

import java.util.stream.Stream;

import static problem.Solution.problem;
import static utils.FileUtils.concat;

public class Problem22 {
    public static final Stream<String> NAMES = concat(
            FileUtils.getNames("/0022_names.txt"),"\"ANN\",\"BOB\"");

    private Problem22() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=22
        problem("Names scores",
        () -> forFile(NAMES));
    }

    public static long forFile(Stream<String> names) {
        return Score.of(names);
    }
}
