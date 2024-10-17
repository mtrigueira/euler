package utils.card;

public record Game(Hand player1, Hand player2) {
    Game(String player1, String player2) {
        this(new Hand(player1), new Hand(player2));
    }

    public Game(String game) {
        this(game.substring(0, 14), game.substring(15, 29));
    }

    public String result() {
        return player1.beats(player2) ? "Player 1" : "Player 2";
    }
}
