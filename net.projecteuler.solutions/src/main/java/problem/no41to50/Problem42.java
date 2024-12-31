package problem.no41to50;

import utils.FileUtils;
import utils.Worth;

import java.math.BigInteger;
import java.util.stream.Stream;

import static problem.Solution.problem;
import static utils.FileUtils.concat;
import static utils.polyagonal.Polygonal.TRIANGULAR;

public class Problem42 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=42
        problem("Coded triangle numbers",
                () -> countTriangularWords(concat(FileUtils.getNames(WORDS_TXT), "SKY")));
    }

    public static final String WORDS_TXT = "/0042_words.txt";

    static long countTriangularWords(Stream<String> words) {
        return words
                .map(Worth::wordWorth)
                .map(BigInteger::valueOf)
                .filter(TRIANGULAR::is)
                .count();
    }

    private Problem42() {}

}
