package problem.no51to60;

import utils.FileUtils;
import utils.card.Game;
import utils.card.Result;

import java.util.stream.Stream;

import static problem.Solution.problem;

public class Problem54 {
     private Problem54() {
     }

    public static final String POKER_TXT = "/0054_poker.txt";

    public static void main(String[] args) {
        // https://projecteuler.net/problem=54
        problem("Poker hands",
        () -> countPlayer1Wins(FileUtils.getNames(POKER_TXT)));
    }

    static long countPlayer1Wins(Stream<String> games) {
        return games
                .map(Game::new)
                .map(Game::result)
                .filter(Result::isLeft)
                .count();
    }

}

