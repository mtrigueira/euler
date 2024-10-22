package utils.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.card.Game.beats;

class HandTest {
    static final Card NINE = new Card("9H");
    static final Card TEN = new Card("TH");
    static final Card JACK = new Card("JH");
    static final Hand WORST = new Hand("2H 3H 4D 5S 7C");
    static final Hand WORST_BUT_1 = new Hand("2H 3H 4H 5H 8D");
    static final Hand HIGH_TEN = new Hand("2H 3H 4H 5H TD");
    static final Hand HIGH_JACK = new Hand("2H 3H 4H 5H JD");
    static final Hand ONE_PAIR_TWOS_5_HIGH = new Hand("2H 2D 3H 4H 5H");
    static final Hand ONE_PAIR_THREES_5_HIGH = new Hand("3H 3D 2H 4H 5H");
    static final Hand ONE_PAIR_TWOS_6_HIGH = new Hand("2H 2D 3H 4H 6H");
    static final Hand TWO_PAIR_TWOS_AND_THREES_4_HIGH = new Hand("2H 2D 3H 3D 4H");
    static final Hand THREE_OF_A_KIND_TWOS_4_HIGH = new Hand("2H 2D 2C 3H 4H");
    static final Hand STRAIGHT_6_HIGH = new Hand("2H 3D 4H 5H 6H");
    static final Hand FLUSH_7_HIGH = new Hand("2H 3H 4H 5H 7H");
    static final Hand FULL_HOUSE_TWOS_THREES = new Hand("2H 2D 2C 3H 3D");
    static final Hand FULL_HOUSE_TWOS_FOURS = new Hand("2H 2D 2H 4H 4D");
    static final Hand FOUR_OF_A_KIND_TWOS_3_HIGH = new Hand("2H 2D 2C 2S 3H");
    static final Hand STRAIGHT_FLUSH_6_HIGH = new Hand("2H 3H 4H 5H 6H");
    public static final Result PLAYER_2 = Result.RIGHT;
    private static final Result PLAYER_1 = Result.LEFT;

    @Test
    void testHand() {
        assertTrue(beats(WORST_BUT_1,WORST));
        assertFalse(beats(WORST,WORST_BUT_1));
    }

    @Test
    void testHighest() {
        assertEquals(new Card("7C"), WORST.highest());
    }

    @Test
    void testCardValue() {
        assertEquals(7, new Card("7H").value());
    }


    @Test
    void testCardGreaterThan() {
        assertTrue(JACK.greaterThan(TEN));
        assertFalse(TEN.greaterThan(JACK));
        assertTrue(TEN.greaterThan(NINE));
    }

    @Test
    void testMaxOfAKind() {
        assertEquals(1, WORST.maxOfAKind());
        assertEquals(2, ONE_PAIR_TWOS_5_HIGH.maxOfAKind());
    }

    @Test
    void testHighCardBeats() {
        assertBeats(HIGH_JACK, HIGH_TEN);
        assertBeats(new Hand("3H 5D 6H 7H 8H"), new Hand("2H 5D 6H 7H 8H"));
    }

    @Test
    void testHighestPair() {
        assertEquals(2, ONE_PAIR_TWOS_5_HIGH.highestPair());
        assertEquals(3, ONE_PAIR_THREES_5_HIGH.highestPair());
    }

    @Test
    void testOnePair() {
        assertBeats(ONE_PAIR_TWOS_5_HIGH, HIGH_TEN);
        assertBeats(ONE_PAIR_THREES_5_HIGH, ONE_PAIR_TWOS_5_HIGH);
        assertBeats(ONE_PAIR_TWOS_6_HIGH, ONE_PAIR_TWOS_5_HIGH);
    }

    @Test
    void testTwoPair() {
        assertBeats(TWO_PAIR_TWOS_AND_THREES_4_HIGH, ONE_PAIR_THREES_5_HIGH);
    }

    @Test
    void testThreeOfAKind() {
        assertBeats(THREE_OF_A_KIND_TWOS_4_HIGH, TWO_PAIR_TWOS_AND_THREES_4_HIGH);
    }

    @Test
    void testHighestCardInStraight() {
        assertEquals(6, STRAIGHT_6_HIGH.highestCardInStraight());
    }

    @Test
    void testStraight() {
        assertBeats(STRAIGHT_6_HIGH, THREE_OF_A_KIND_TWOS_4_HIGH);
    }

    @Test
    void testSuits() {
        assertEquals("H", FLUSH_7_HIGH.suits());
        //noinspection SpellCheckingInspection
        assertEquals("HDCS", WORST.suits());
    }

    @Test
    void testFlush() {
        assertBeats(FLUSH_7_HIGH, STRAIGHT_6_HIGH);
    }

    @Test
    void testFullHouse() {
        assertBeats(FULL_HOUSE_TWOS_THREES, FLUSH_7_HIGH);
        assertBeats(FULL_HOUSE_TWOS_FOURS, FULL_HOUSE_TWOS_THREES);
    }

    @Test
    void testFourOfAKind() {
        assertBeats(FOUR_OF_A_KIND_TWOS_3_HIGH, FULL_HOUSE_TWOS_FOURS);
    }

    @Test
    void testStraightFlush() {
        assertBeats(STRAIGHT_FLUSH_6_HIGH, FOUR_OF_A_KIND_TWOS_3_HIGH);
    }

    @Test
    void testGame() {
        assertWinner(PLAYER_2, "5H 5C 6S 7S KD", "2C 3S 8S 8D TD");
        assertWinner(PLAYER_1, "5D 8C 9S JS AC", "2C 5C 7D 8S QH");
        assertWinner(PLAYER_2, "2D 9C AS AH AC", "3D 6D 7D TD QD");
        assertWinner(PLAYER_1, "4D 6S 9H QH QC", "3D 6D 7H QD QS");
        assertWinner(PLAYER_1, "2H 2D 4C 4D 4S", "3C 3D 3S 9S 9D");
    }

    private static void assertWinner(Result expected, String p1, String p2) {
        assertEquals(expected, new Game(p1, p2).result());
    }

    void assertBeats(Hand hand1, Hand hand2) {
        assertTrue(beats(hand1,hand2));
        assertFalse(beats(hand2,hand1));
    }
}