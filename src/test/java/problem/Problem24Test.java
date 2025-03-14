package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem24Test {
    private static class Singleton {
        int i = 1;
        int j = 1;
        int k = 1;
    }
    private static Singleton INSTANCE = new Singleton();

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"0", "01", "012", "0123", "01234"})
    void permutation1(String permutation) {
        assertEquals(permutation, Problem24.permutation(1, permutation));
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"10", "021", "0132", "01243"})
    void permutation2(String permutation) {
        assertEquals(permutation, Problem24.permutation(2, sorted(permutation)));
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"102", "0213", "01324"})
    void permutation3(String permutation) {
        assertEquals(permutation, Problem24.permutation(3, sorted(permutation)));
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"01", "10"})
    void permutation01(String permutation) {
        assertEquals(permutation, Problem24.permutation(INSTANCE.i++, "01"));
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"012", "021", "102", "120", "201", "210"})
    void permutation012(String permutation) {
        assertEquals(permutation, Problem24.permutation(INSTANCE.j++, "012"));
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"0123", "0132", "0213", "0231", "0312", "0321","1023"})
    void permutation0123(String permutation) {
        assertEquals(permutation, Problem24.permutation(INSTANCE.k++, "0123"));
    }

    private static String sorted(String permutation) {
        return permutation.chars().sorted().mapToObj(c->(char)c+"").reduce("", (a, b)->a+b);
    }
}
