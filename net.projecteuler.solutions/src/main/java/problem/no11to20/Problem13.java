package problem.no11to20;

import utils.FileUtils;

import java.math.BigInteger;
import java.util.stream.Stream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem13 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=13
        problem("Large sum");
        solution(sum(NUMBERS).substring(0,10));
    }

    static final Stream<String> NUMBERS = FileUtils.getStrings("/0013_numbers.txt");

    static String sum(Stream<String> numbers) {
        return numbers
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add)
                .toString();
    }
}
