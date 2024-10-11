package problem.no11to20;

import utils.data.NumberWord;

import java.util.stream.IntStream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem17 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=17
        problem("Number letter counts");
        solution(forNumbersTo(1000));
    }

    private static final String NOT_ALPHABETIC = "[^a-z]";
    static int forNumbersTo(int n) {
        return IntStream.rangeClosed(1, n)
                .map(Problem17::lengthOfWordsExcludingNonAlphabeticCharacters)
                .sum();
    }

    private static int lengthOfWordsExcludingNonAlphabeticCharacters(int number) {
        return wordsExcludingNonAlphabeticCharacters(number).length();
    }

    private static String wordsExcludingNonAlphabeticCharacters(int number) {
        return NumberWord.of(number).replaceAll(NOT_ALPHABETIC, "");
    }
}
