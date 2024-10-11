package problem.no21to30;

import utils.FileUtils;
import problem.no21to30.library22.Score;

public class Problem22 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=22
        System.out.println(forFile("/0022_names.txt"));
    }

    public static long forFile(String file) {
        return Score.of(FileUtils.getNames(file));
    }
}
