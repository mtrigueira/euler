package problem.no41to50;

import utils.FileUtils;
import utils.Worth;
import utils.property.Triangular;

public class Problem42 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=42
        System.out.println(forFile("/0042_words.txt"));
    }

    public static long forFile(String file) {
        return FileUtils.getNames(file)
                .map(Worth::wordWorth)
                .filter(Triangular::isTriangular)
                .count();
    }
}
