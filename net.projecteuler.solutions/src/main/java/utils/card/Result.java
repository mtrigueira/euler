package utils.card;

public enum Result {
    LEFT, TIE, RIGHT;

    Result or(Result chain) {
        if (this == TIE) return chain;
        return this;
    }

    boolean or(boolean chain) {
        if (this == TIE) return chain;
        return this == LEFT;
    }

    public boolean isLeft() {
        return this == LEFT;
    }
}
