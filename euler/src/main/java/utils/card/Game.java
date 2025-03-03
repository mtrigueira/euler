package utils.card;

import static utils.card.Result.*;

public record Game(Hand player1, Hand player2) {
    Game(String player1, String player2) {
        this(new Hand(player1), new Hand(player2));
    }

    public Game(String game) {
        this(game.substring(0, 14), game.substring(15, 29));
    }

    static boolean beats(Hand left, Hand right) {
        return straightFlushBeats(left, right)
                .or(fourOfAKindBeats(left, right))
                .or(fullHouseBeats(left, right))
                .or(flushBeats(left, right))
                .or(straightBeats(left, right))
                .or(threeOfAKindBeats(left, right))
                .or(twoPairBeats(left, right))
                .or(onePairBeats(left, right))
                .or(highCardBeats(left, right));
    }

    private static Result straightFlushBeats(Hand left, Hand right) {
        boolean leftFlush = left.suits().length() == 1;
        boolean rightFlush = right.suits().length() == 1;
        byte i = left.highestCardInStraight();
        byte a = right.highestCardInStraight();
        boolean isLeftStraightFlush = leftFlush && i != 0;
        boolean isRightStraightFlush = rightFlush && a != 0;

        if (isLeftStraightFlush == isRightStraightFlush) {
            return TIE;
        }

        return isLeftStraightFlush ? LEFT : RIGHT;
    }

    private static Result fourOfAKindBeats(Hand left, Hand right) {
        byte i = left.highestFourOfAKind();
        byte a = right.highestFourOfAKind();
        if (a == i)
            return TIE;
        return i > a ? LEFT : RIGHT;
    }

    private static Result fullHouseBeats(Hand left, Hand right) {
        byte leftThreeOfAKind = left.highestThreeOfAKind();
        byte rightThreeOfAKind = right.highestThreeOfAKind();
        byte leftPair = left.highestPair();
        byte rightPair = right.highestPair();
        boolean isLeftFullHouse = leftThreeOfAKind != 0 && leftPair != 0;
        boolean isRightFullHouse = rightThreeOfAKind != 0 && rightPair != 0;
        if (isRightFullHouse == isLeftFullHouse) {
            return TIE;
        }

        return isLeftFullHouse ? LEFT : RIGHT;
    }

    private static Result flushBeats(Hand left, Hand right) {
        boolean leftFlush = left.suits().length() == 1;
        boolean rightFlush = right.suits().length() == 1;
        if (leftFlush == rightFlush)
            return TIE;
        return leftFlush ? LEFT : RIGHT;
    }

    private static Result straightBeats(Hand left, Hand right) {
        byte i = left.highestCardInStraight();
        byte a = right.highestCardInStraight();
        if (a == i)
            return TIE;
        return i > a ? LEFT : RIGHT;
    }

    private static Result threeOfAKindBeats(Hand left, Hand right) {
        byte i = left.highestThreeOfAKind();
        byte a = right.highestThreeOfAKind();
        if (a == i)
            return TIE;
        return i > a ? LEFT : RIGHT;
    }

    private static Result twoPairBeats(Hand left, Hand right) {
        byte leftHighestPair = left.secondHighestPair();
        byte rightHighestPair = right.secondHighestPair();
        if (rightHighestPair == leftHighestPair)
            return TIE;
        return leftHighestPair > rightHighestPair ? LEFT : RIGHT;
    }

    static Result onePairBeats(Hand left, Hand right) {
        byte leftHighestPair = left.highestPair();
        byte rightHighestPair = right.highestPair();

        if (rightHighestPair == leftHighestPair)
            return TIE;
        return leftHighestPair > rightHighestPair ? LEFT : RIGHT;
    }

    static boolean highCardBeats(Hand left, Hand right) {
        for (int i = 4; i >= 0; i--) {
            Card leftCard = left.cards[i];
            Card rightCard = right.cards[i];

            if (leftCard.greaterThan(rightCard))
                return true;
            if (rightCard.greaterThan(leftCard))
                return false;
        }

        return false;
    }

    public Result result() {
        return beats(player1, player2) ? LEFT : RIGHT;
    }
}
