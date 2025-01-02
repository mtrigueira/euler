package problem.no91to100;

import utils.SimpleFraction;

import java.util.*;

import static problem.Solution.problem;

public class Problem93 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=93
        problem("Arithmetic Expressions", () ->
                Problem93.solution(10));
    }

    static List<Integer> eval(int... a) {
        List<Integer> todo = new ArrayList<>(4);

        for (int i : a)
            todo.add(i);

        return onlyIntegers(firstTwoAndThenCallOn(todo));
    }

    private static Set<SimpleFraction> firstTwoAndThenCallOn(List<Integer> todo) {
        Set<SimpleFraction> solutions = new HashSet<>();
        for (int a : todo) {
            for (int b : todo) {
                if (a == b)
                    continue;
                HashSet<SimpleFraction> partials = new HashSet<>();
                applyOps(partials, SimpleFraction.of(a), b);

                solutions.addAll(third(stillTodo(todo, a, b), partials));
            }
        }
        return solutions;
    }

    private static List<Integer> stillTodo(List<Integer> todo, int a, int b) {
        return stillTodo(stillTodo(todo, a), b);
    }

    private static Set<SimpleFraction> third(List<Integer> todo, Set<SimpleFraction> partials) {
        Set<SimpleFraction> solutions = new HashSet<>();

        for (int c : todo) {
            Set<SimpleFraction> found = new HashSet<>();
            for (SimpleFraction part : partials)
                applyOps(found, part, c);

            solutions.addAll(fourth(stillTodo(todo, c), found));
        }

        return solutions;
    }

    private static List<Integer> stillTodo(List<Integer> todo, int c) {
        List<Integer> stillTodo = new ArrayList<>();

        for (int d : todo)
            if (c != d)
                stillTodo.add(d);

        return stillTodo;
    }

    private static Set<SimpleFraction> fourth(List<Integer> todo, Set<SimpleFraction> partials) {
        HashSet<SimpleFraction> found = new HashSet<>();

        for (SimpleFraction part : partials)
            applyOps(found, part, todo.getFirst());

        found.removeIf(f -> f.numerator().signum() <= 0);

        return found;
    }

    private static void applyOps(Set<SimpleFraction> found, SimpleFraction a, int bInt) {
        SimpleFraction b = SimpleFraction.of(bInt);
        found.add(a.add(b));
        found.add(a.subtract(b));
        found.add(b.subtract(a));
        found.add(a.multiply(b));
        found.add(a.divide(b)); // No need to check b is non-zero since b is provided > 0
        if (!SimpleFraction.ZERO.equals(a))
            found.add(b.divide(a));
    }

    static int consecutive(Collection<Integer> integers) {
        int c = 0;
        for (; c < integers.size(); c++)
            if (!integers.contains(c + 1))
                break;
        return c;
    }

    static List<Integer> onlyIntegers(Set<SimpleFraction> ev) {
        return ev.stream()
                .filter(SimpleFraction::isInteger)
                .map(f -> f.toBigIntegerExact().intValueExact())
                .distinct()
                .sorted()
                .toList();
    }

    static String solution(int limit) {
        int maxConsecutive = -1;
        String digitsAsString = "Not found";

        for (int a = 1; a < limit - 3; a++)
            for (int b = a + 1; b < limit - 2; b++)
                for (int c = b + 1; c < limit - 1; c++)
                    for (int d = c + 1; d < limit; d++) {
                        int consecutive = consecutive(eval(a, b, c, d));
                        if (consecutive > maxConsecutive) {
                            digitsAsString = "" + a + b + c + d;
                            maxConsecutive = consecutive;
                        }
                    }

        return digitsAsString;
    }

    private Problem93() {}
}
