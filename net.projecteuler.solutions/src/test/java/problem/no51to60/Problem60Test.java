package problem.no51to60;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Problem60Test {
    @Test
    void test2() {
        assertEquals(10, Problem60.sumOfPrimePairSets(2));
    }

    @Test
    void test3() {
        assertEquals(107, Problem60.sumOfPrimePairSets(3));
    }

    @Test
    void test4() {
        assertEquals(792, Problem60.sumOfPrimePairSets(4));
    }

    @Test
    void node() {
        Problem60.sumOfPrimePairSets(0);
        Problem60.Node n3 = new Problem60.Node(3);
        Problem60.Node n7 = new Problem60.Node(7);
        assertNull(n3.children);
        n3.add(n3.p);
        assertNull(n3.children);
        n3.add(n7.p);
        assertArrayEquals(Set.of(n7).toArray(),n3.children.toArray());
    }

    @Test
    void concat() {
        assertEquals(10,Problem60.concat(1L,0L));
        assertEquals(1,Problem60.concat(0L,1L));
        assertEquals(23,Problem60.concat(2L,3L));
        assertEquals(345,Problem60.concat(3L,45L));
    }
}