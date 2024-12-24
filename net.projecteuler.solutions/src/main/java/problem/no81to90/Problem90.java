package problem.no81to90;

import java.util.HashSet;
import java.util.Set;

import static problem.Solution.problem;

public class Problem90 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=90
        problem("Cube digit pairs", Problem90::solution);
    }

    private static int solution() {
        Set<Square> squares = squares();
        HashSet<Set<Integer>> dice = Die.dice();

        int count = 0;

        for (Set<Integer> red : new HashSet<>(dice)) {
            dice.remove(red);
            for (Set<Integer> green : dice)
                if (allPairsCanBeMatched(red, green, squares))
                    count++;
        }

        return count;
    }

    private static boolean allPairsCanBeMatched(Set<Integer> red, Set<Integer> green, Set<Square> squares) {
        for (Square p : squares)
            if (!isPossibleCombo(red, green, p))
                return false;

        return true;
    }

    private static int allowSubstitute(int i) {
        if (i == 9)
            return 6;
        return i;
    }

    private static boolean isPossibleCombo(Set<Integer> red, Set<Integer> green, Square p) {
        int left = allowSubstitute(p.left);
        int right = allowSubstitute(p.right);
        if (red.contains(left) && green.contains(right))
            return true;
        return red.contains(right) && green.contains(left);
    }

    private static Set<Square> squares() {
        Set<Square> pairs = new HashSet<>();

        for (int i = 1; i < Math.sqrt(100); i++)
            pairs.add(new Square(i * i));

        return pairs;
    }

    record Square(int i, int left, int right) {
        Square(int i) {
            this(i, i / 10, i % 10);
        }
    }

    static class Die {
        private static void combos(HashSet<Set<Integer>> combos, HashSet<Integer> integers) {
            for (int i = 0; i <= 9; i++) {
                if (!integers.add(i))
                    continue;
                if (integers.size() == 6)
                    combos.add(new HashSet<>(integers));
                else
                    combos(combos, integers);
                integers.remove(i);
            }
        }

        private static HashSet<Set<Integer>> dice() {
            HashSet<Set<Integer>> dice = new HashSet<>();
            combos(dice, new HashSet<>());
            for (Set<Integer> die : dice)
                allowSubstitutes(die);

            dice = new HashSet<>(dice);
            return dice;
        }

        private static void allowSubstitutes(Set<Integer> set) {
            if (set.contains(9))
                set.add(6);
        }

        private Die() {
        }
    }

    private Problem90() {
    }
}
