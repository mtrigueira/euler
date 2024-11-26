package problem.no1to10;

import utils.FileUtils;
import utils.sequence.given.WideNumberProductSequence;

import static problem.Solution.problem;
import static utils.FileUtils.concat;

public class Problem8 {
    public static final String BIG_NUMBER = concat(FileUtils.getStrings("/0008_numbers.txt"),"9989")
            .reduce("", String::concat);

    private Problem8() {
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=8
        problem("Largest product in a series",
                () -> greatestProductOfAdjacentDigits(13, BIG_NUMBER));
    }

    static Long greatestProductOfAdjacentDigits(int numberOfAdjacentDigits, String bigNumber) {
        return new WideNumberProductSequence(bigNumber, numberOfAdjacentDigits).stream()
                .reduce(0L, Long::max);
    }
}
