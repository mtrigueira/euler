package utils.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupTest {
    @Test
    void compareGroups() {
        assertEquals(0, new Group(1, 2, 3).compareGroups(new Group(1, 2, 3)));
        assertEquals(2, new Group(3, 2, 1).compareGroups(new Group(1, 2, 3)));
        assertEquals(-2, new Group(1, 2, 3).compareGroups(new Group(3, 2, 1)));
        assertEquals(9, new Group(10, 2, 3).compareGroups(new Group(1, 2, 3)));
    }
}