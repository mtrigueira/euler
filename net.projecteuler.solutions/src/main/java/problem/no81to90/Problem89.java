package problem.no81to90;

import utils.FileUtils;
import utils.roman.Roman;

import java.util.stream.Stream;

import static problem.Solution.problem;
import static utils.FileUtils.concat;

public class Problem89 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=89
        problem("Roman numerals", Problem89::solution);
    }

    private static int solution() {
        Stream<String> strings = concat(FileUtils.getStrings("/0089_roman.txt"),
                "XIIIIII\nM\nCM\nD\nCD\nC\nXC\nL\nXL\nIX\nIV\nI\n");
        return strings
                .mapToInt(roman -> roman.length() - Roman.parseRoman(roman).toString().length())
                .sum();
    }

    private Problem89() {}
}

