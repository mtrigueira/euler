package problem17;

public class NumberLetterCounts {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=17
        System.out.println(forNumbersTo(1000));
    }

    private static final String NOT_ALPHABETIC = "[^a-z]";
    static int forNumbersTo(int n) {
        int sum=0;

        for(int i = 1; i<=n; i++)
            sum += lengthOfWordsExcludingNonAlphabeticCharactersFor(i);

        return sum;
    }

    private static int lengthOfWordsExcludingNonAlphabeticCharactersFor(int number) {
        return wordsExcludingNonAlphabeticCharactersFor(number).length();
    }

    private static String wordsExcludingNonAlphabeticCharactersFor(int number) {
        return NumberWord.of(number).replaceAll(NOT_ALPHABETIC, "");
    }
}
