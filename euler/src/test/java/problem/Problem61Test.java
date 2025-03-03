package problem;

import org.junit.jupiter.api.Test;
import utils.polyagonal.Polygonal;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.polyagonal.Polygonal.*;

class Problem61Test {
    public static final Problem61.Node EG3 = new Problem61.Node(3, List.of(TRIANGULAR), List.of());
    public static final Problem61.Node EG4 = new Problem61.Node(4, List.of(SQUARE), List.of(EG3));

    @Test
    void cyclicNumbersWithUniquePolygonals() {
        assertEquals(19291, Problem61.cyclicNumbersWithUniquePolygonals(3));
    }

    @Test
    void areDifferentPolygonals() {
        assertTrue(Problem61.areDifferentPolygonals(EG3, EG4));
        assertFalse(Problem61.areDifferentPolygonals(EG3, EG3));
        assertFalse(Problem61.areDifferentPolygonals(nodes(1426,2628,2850,5041,4186,8614)));
        assertFalse(Problem61.areDifferentPolygonals(nodes(1128,2821,2116,1651,5192,9211)));
    }

    @Test
    void toStringTest() {
        assertEquals("3 is [Triangular], next []", EG3.toString());
        assertEquals("4 is [Square], next [3]", EG4.toString());
    }

    Problem61.Node[] nodes(int... i) {
        return Arrays.stream(i).mapToObj(a->new Problem61.Node(a,polygonalsOf(a),List.of())).toArray(Problem61.Node[]::new);
    }

    private static List<Polygonal> polygonalsOf(int i) {
        return POLYGONALS.stream().filter(p -> p.is(i)).toList();
    }
}