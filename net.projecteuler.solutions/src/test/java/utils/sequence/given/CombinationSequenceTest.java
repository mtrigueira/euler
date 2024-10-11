package utils.sequence.given;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSequenceTest {

    @Test
    void comboAB() {
        CombinationSequence<String> cs = new CombinationSequence<>(List.of("A","B"),(a,b)-> a+b);
        assertTrue(cs.hasNext());
        assertEquals("AB", cs.next());
        assertTrue(cs.hasNext());
        assertEquals("BA", cs.next());
        assertFalse(cs.hasNext());
        assertThrows(NoSuchElementException.class, cs::next);
    }

    @Test
    void combo012() {
        CombinationSequence<String> cs = new CombinationSequence<>(List.of("0","1","2"),(a,b)-> a+b);
        assertTrue(cs.hasNext());
        assertEquals("012", cs.next());
        assertTrue(cs.hasNext());
        assertEquals("021", cs.next());
        assertTrue(cs.hasNext());
        assertEquals("102", cs.next());
        assertTrue(cs.hasNext());
        assertEquals("120", cs.next());
        assertTrue(cs.hasNext());
        assertEquals("201", cs.next());
        assertTrue(cs.hasNext());
        assertEquals("210", cs.next());
        assertFalse(cs.hasNext());
        assertThrows(NoSuchElementException.class, cs::next);
    }
}