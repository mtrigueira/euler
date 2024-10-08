package utils;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinerTest {
    String combined = "";

    @Test
    void combine1() {
        Combiner<Integer> combiner = Combiner.of(Set.of(1));
        combiner.combine(this::addToString);
        assertEquals("1,\n", combined);
    }

    @Test
    void combine2() {
        Combiner<Integer> combiner = Combiner.of(Set.of(1, 2));
        combiner.combine(this::addToString);
        assertEquals("1,2,\n2,1,\n", combined);
    }

    @Test
    void combine3() {
        Combiner<Integer> combiner = Combiner.of(Set.of(1, 2, 3));
        combiner.combine(this::addToString);
        assertEquals("1,2,3,\n1,3,2,\n2,1,3,\n2,3,1,\n3,1,2,\n3,2,1,\n", combined);
    }

    void addToString(List<Integer> combination) {
        for (Integer i : combination)
            combined += i + ",";

        combined += "\n";
    }
}