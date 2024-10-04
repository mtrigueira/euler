package problem24;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexicographicPermutationsTest {
    static int i = 1;
    static int j = 1;
    static int k = 1;

    @ParameterizedTest
    @ValueSource(strings = {"0", "01", "012", "0123", "01234"})
    void permutation1(String permutation) {
        assertEquals(permutation, LexicographicPermutations.permutation(1, permutation));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10", "021", "0132", "01243"})
    void permutation2(String permutation) {
        assertEquals(permutation, LexicographicPermutations.permutation(2, permutation));
    }

    @ParameterizedTest
    @ValueSource(strings = {"102", "0213", "01324"})
    void permutation3(String permutation) {
        assertEquals(permutation, LexicographicPermutations.permutation(3, permutation));
    }

    @ParameterizedTest
    @ValueSource(strings = {"01", "10"})
    void permutation01(String permutation) {
        assertEquals(permutation, LexicographicPermutations.permutation(i++, "01"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "021", "102", "120", "201", "210"})
    void permutation012(String permutation) {
        assertEquals(permutation, LexicographicPermutations.permutation(j++, "012"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123", "0132", "0213", "0231", "0312", "0321","1023"})
    void permutation0123(String permutation) {
        assertEquals(permutation, LexicographicPermutations.permutation(k++, "0123"));
    }
}