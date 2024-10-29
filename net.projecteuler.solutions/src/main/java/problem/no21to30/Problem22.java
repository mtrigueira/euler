package problem.no21to30;

import utils.FileUtils;
import utils.Score;

import static problem.Solution.problem;

public class Problem22 {
     private Problem22() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=22
        problem("Names scores",
        () -> forFile("/0022_names.txt"));
    }

    public static long forFile(String file) {
        return Score.of(FileUtils.getNames(file));
    }
}
