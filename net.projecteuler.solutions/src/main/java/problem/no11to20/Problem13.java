package problem.no11to20;

import utils.FileUtils;

import java.math.BigInteger;
import java.util.stream.Stream;

import static problem.Solution.problem;
import static utils.FileUtils.concat;

public class Problem13 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=13
        problem("Large sum",
                () -> left(sum(concat(FileUtils.getStrings(NUMBERS_TXT), "0"))));
    }

    public static final String NUMBERS_TXT = "/0013_numbers.txt";
    public static final int NUMBER_OF_CHARACTERS = 10;

    private static String left(String string) {
        return string.substring(0, Math.min(NUMBER_OF_CHARACTERS, string.length()));
    }

    static String sum(Stream<String> numbers) {
        return numbers
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add)
                .toString();
    }

    private Problem13() {}
}
