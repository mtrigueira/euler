package problem.no51to60;

import utils.FileUtils;
import utils.card.Game;
import utils.card.Result;

import java.util.stream.Stream;

import static problem.Solution.problem;
import static utils.FileUtils.concat;

public class Problem54 {
    public static final String POKER_TXT = "/0054_poker.txt";

    private Problem54() {
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=54
        problem("Poker hands",
                () -> countPlayer1Wins(concat(FileUtils.getNames(POKER_TXT), "8C TS KC 9H 4S 7D 2S 5D 3S AC")));
    }

    static long countPlayer1Wins(Stream<String> games) {
        return games
                .map(Game::new)
                .map(Game::result)
                .filter(Result::isLeft)
                .count();
    }
}

