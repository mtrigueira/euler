package problem.no51to60;

import utils.FileUtils;
import utils.card.Game;
import utils.card.Result;

import java.util.stream.Stream;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem54 {

    public static final Stream<String> GAMES = FileUtils.getStrings("/0054_poker.txt");

    public static void main(String[] args) {
        // https://projecteuler.net/problem=54
        problem("Poker hands");
        solution(countPlayer1Wins(GAMES));
    }

    static long countPlayer1Wins(Stream<String> games) {
        return games
                .map(Game::new)
                .map(Game::result)
                .filter(Result::isLeft)
                .count();
    }
}

