package problem.no51to60;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("3",n3.toString());
        n3.add(n3);
        assertEquals("3",n3.toString());
        n3.add(n7);
        assertEquals("3\n 7",n3.toString());
    }
}