package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    public static final Group G123 = new Group(1, 2, 3);
    public static final Group G124 = new Group(1, 2, 4);
    public static final Group G134 = new Group(1, 3, 4);
    public static final Group G321 = new Group(3, 2, 1);

    @Test
    void compareGroups() {
        assertEquals(0, G123.compareGroups(G123));
        assertEquals(-1, G123.compareGroups(G124));
        assertEquals(-1, G123.compareGroups(G134));
        assertEquals(2, G321.compareGroups(G123));
        assertEquals(-2, G123.compareGroups(G321));
        assertEquals(9, new Group(10, 2, 3).compareGroups(G123));
    }

    @Test
    void equals() {
        assertEquals(G123,G123);
        assertNotEquals(G123,G124);
        assertNotEquals(G123,G134);
        assertNotEquals(G321,G123);

        //noinspection EqualsBetweenInconvertibleTypes,SimplifiableAssertion
        assertFalse(G123.equals("Dummy"));
    }

    @Test
    void hashCodeTest() {
        //noinspection EqualsWithItself
        assertEquals(G123.hashCode(),G123.hashCode());
        assertNotEquals(G123.hashCode(),G124.hashCode());
        assertNotEquals(G123.hashCode(),G134.hashCode());

        // IMPLEMENTATION SPECIFIC RESULT
        assertEquals(G321.hashCode(),G123.hashCode());
    }

    @Test
    void toStringTest() {
        assertEquals("1,2,3",G123.toString());
    }
}