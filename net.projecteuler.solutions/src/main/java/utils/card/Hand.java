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
        this.cards = Arrays.stream(cards.split(" "))
                .map(Card::new)
                .sorted(Comparator.comparingInt(Card::value))
                .toArray(Card[]::new);
    }

    Card highest() {
        Stream<Card> cards1 = Arrays.stream(cards);
        return cards1.reduce((a, b) -> a.greaterThan(b) ? a : b).orElseThrow();
    }

    byte highestCardInStraight() {
        return Arrays.stream(cards)
                .map(Card::value)
                .sorted()
                .reduce((a, b) -> a + 1 == b ? b : 0)
                .orElse((byte) 0);
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

    @Override
    public String toString() {
        return "Hand" + Arrays.toString(cards);
    }

}
