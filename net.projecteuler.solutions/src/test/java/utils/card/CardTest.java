package utils.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void testToString() {
        Card card = new Card("AS");
        assertEquals("AS", card.toString());
    }
}