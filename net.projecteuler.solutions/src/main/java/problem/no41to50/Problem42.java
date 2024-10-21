package problem.no41to50;

import utils.FileUtils;
import utils.Worth;

import java.math.BigInteger;

import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.polyagonal.Polygonal.TRIANGULAR;

public class Problem42 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=42
        problem("Coded triangle numbers");
        solution(forFile("/0042_words.txt"));
    }

    public static long forFile(String file) {
        return FileUtils.getNames(file)
                .map(Worth::wordWorth)
                .map(BigInteger::valueOf)
                .filter(TRIANGULAR::is)
                .count();
    }
}
