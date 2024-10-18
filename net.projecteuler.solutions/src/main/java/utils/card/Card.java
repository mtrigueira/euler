package utils.card;

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
