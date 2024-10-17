package utils.card;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hand {
    final Card[] cards;

    public Hand(String cards) {
        this.cards = Arrays.stream(cards.split(" ")).map(Card::new).sorted(Comparator.comparingInt(a -> a.value)).toArray(Card[]::new);
    }

    Card highest() {
        Stream<Card> cards1 = Arrays.stream(cards);
        return cards1.reduce((a, b) -> a.greaterThan(b) ? a : b).orElseThrow();
    }

    boolean beats(Hand that) {
        return straightFlushBeats(that)
                .or(fourOfAKindBeats(that))
                .or(fullHouseBeats(that))
                .or(flushBeats(that))
                .or(straightBeats(that))
                .or(threeOfAKindBeats(that))
                .or(twoPairBeats(that))
                .or(onePairBeats(that))
                .or(highCardBeats(that));
    }

    private Result straightFlushBeats(Hand that) {
        boolean thisFlush = suits().length() == 1;
        boolean thatFlush = that.suits().length() == 1;
        byte i = highestCardInStraight();
        byte a = that.highestCardInStraight();
        boolean isThisStraightFlush = thisFlush && i != 0;
        boolean isThatStraightFlush = thatFlush && a != 0;

        if (isThisStraightFlush == isThatStraightFlush) {
            return Result.DRAW;
        }

        return isThisStraightFlush ? Result.WIN : Result.LOSE;
    }

    private Result fourOfAKindBeats(Hand that) {
        byte i = highestFourOfAKind();
        byte a = that.highestFourOfAKind();
        if (a == i) return Result.DRAW;
        return i > a ? Result.WIN : Result.LOSE;
    }

    private Result fullHouseBeats(Hand that) {
        byte thisThreeOfAKind = highestThreeOfAKind();
        byte thatThreeOfAKind = that.highestThreeOfAKind();
        byte thisPair = highestPair();
        byte thatPair = that.highestPair();
        boolean isThisFullHouse = thisThreeOfAKind != 0 && thisPair != 0;
        boolean isThatFullHouse = thatThreeOfAKind != 0 && thatPair != 0;
        if (isThatFullHouse == isThisFullHouse) {
            return Result.DRAW;
        }

        return isThisFullHouse ? Result.WIN : Result.LOSE;
    }

    private Result flushBeats(Hand that) {
        boolean thisFlush = suits().length() == 1;
        boolean thatFlush = that.suits().length() == 1;
        if (thisFlush == thatFlush) return Result.DRAW;
        return thisFlush ? Result.WIN : Result.LOSE;
    }

    private Result straightBeats(Hand that) {
        byte i = highestCardInStraight();
        byte a = that.highestCardInStraight();
        if (a == i) return Result.DRAW;
        return i > a ? Result.WIN : Result.LOSE;
    }

    byte highestCardInStraight() {
        return Arrays.stream(cards)
                .map(Card::value)
                .sorted()
                .reduce((a, b) -> a + 1 == b ? b : 0)
                .orElse((byte) 0);
    }

    private Result threeOfAKindBeats(Hand that) {
        byte i = highestThreeOfAKind();
        byte a = that.highestThreeOfAKind();
        if (a == i) return Result.DRAW;
        return i > a ? Result.WIN : Result.LOSE;
    }

    private Result twoPairBeats(Hand that) {
        byte thisHighestPair = secondHighestPair();
        byte thatHighestPair = that.secondHighestPair();
        if (thatHighestPair == thisHighestPair) return Result.DRAW;
        return thisHighestPair > thatHighestPair ? Result.WIN : Result.LOSE;
    }

    Result onePairBeats(Hand that) {
        byte thisHighestPair = highestPair();
        byte thatHighestPair = that.highestPair();
        if (thatHighestPair == thisHighestPair) return Result.DRAW;
        return thisHighestPair > thatHighestPair ? Result.WIN : Result.LOSE;
    }

    byte highestFourOfAKind() {
        return valueGroups().entrySet().stream()
                .filter(entry -> entry.getValue().size() == 4)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .limit(1)
                .findFirst()
                .orElse((byte) 0);
    }

    byte highestThreeOfAKind() {
        return valueGroups().entrySet().stream()
                .filter(entry -> entry.getValue().size() == 3)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .limit(1)
                .findFirst()
                .orElse((byte) 0);
    }

    byte highestPair() {
        return pairs()
                .limit(1)
                .findFirst()
                .orElse((byte) 0);
    }

    byte secondHighestPair() {
        return pairs()
                .skip(1)
                .limit(1)
                .findFirst()
                .orElse((byte) 0);
    }

    private Stream<Byte> pairs() {
        return valueGroups().entrySet().stream()
                .filter(entry -> entry.getValue().size() == 2)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey);
    }

    String suits() {
        return Arrays.stream(cards)
                .collect(Collectors.groupingBy(Card::suit))
                .keySet().stream()
                .sorted()
                .map(Enum::name)
                .reduce("", (a, b) -> a + b);
    }

    int maxOfAKind() {
        return valueGroups().values().stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private Map<Byte, List<Card>> valueGroups() {
        return Arrays.stream(cards)
                .collect(Collectors.groupingBy(Card::value));
    }

    boolean highCardBeats(Hand that) {
        for (int i = 4; i >= 0; i--) {
            Card thisCard = cards[i];
            Card thatCard = that.cards[i];
            if (thisCard.greaterThan(thatCard)) return true;
            if (thatCard.greaterThan(thisCard)) return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Hand" + Arrays.toString(cards);
    }

    enum Result {
        WIN, LOSE, DRAW;

        Result or(Result that) {
            if (this == DRAW) return that;
            return this;
        }

        boolean or(boolean that) {
            if (this == DRAW) return that;
            return this == WIN;
        }
    }

    enum Suit {
        H, D, C, S
    }

    record Card(byte value, Suit suit) {
        private static final String valueRank = "23456789TJQKA";

        Card(String string) {
            this((byte) (valueRank.indexOf(string.substring(0, 1)) + 2), Suit.valueOf(string.substring(1)));
        }

        boolean greaterThan(Card that) {
            return this.value > that.value;
        }

        @Override
        public String toString() {
            return "" + valueRank.charAt(value - 2) + suit;
        }
    }

}
