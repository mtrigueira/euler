package problem.no51to60;

import utils.FileUtils;
import utils.card.Game;
import utils.card.Result;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem54 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=54
        problem("Poker hands");
        solution(countPlayer1Wins());
    }

    private static long countPlayer1Wins() {
        return FileUtils.getStrings("/0054_poker.txt")
                .map(Game::new)
                .map(Game::result)
                .filter(Result::isLeft)
                .count();
    }
}

