package problem.no71to80;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static problem.Solution.problem;

public class Problem79 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=79
        problem("Passcode derivation", () ->
                shortestPasscode(PINS));
    }

    private static final String[] PINS = ("319,680,180,690,129,620,762,689,762,318,368,710,720,710,629,168," +
            "160,689,716,731,736,729,316,729,729,710,769,290,719,680,318,389,162,289,162,718,729," +
            "319,790,680,890,362,319,760,316,729,380,319,728,716").split(",");

    static String shortestPasscode(String[] pins) {
        Set<String> preceeds = pairs(pins);
        Set<String> leftys = Arrays.stream(pins).map(x -> x.substring(0, 1)).collect(Collectors.toSet());

        StringBuilder last = new StringBuilder();
        while (!preceeds.isEmpty())
            last.insert(0, rightMost(preceeds));

        for (String x : leftys)
            if (!last.toString().contains(x)) last.insert(0, x);

        return last.toString();
    }

    private static Set<String> pairs(String[] strings) {
        Set<String> precedes = new HashSet<>();
        for (String x : strings) {
            String a = x.substring(0, 1);
            String b = x.substring(1, 2);
            String c = x.substring(2, 3);
            precedes.add(a + b);
            precedes.add(b + c);
        }
        return precedes;
    }

    private static String rightMost(Set<String> precedes) {
        Set<String> hasOneOnTheLeft = leftmost(precedes);
        if (hasOneOnTheLeft.size() != 1) throw new RuntimeException("Could not isolate last digit");
        String last = hasOneOnTheLeft.stream().toList().get(0);
        Set<String> filtered = precedes.stream().filter(x -> !x.substring(1, 2).equals(last)).collect(Collectors.toSet());
        precedes.clear();
        precedes.addAll(filtered);
        return last;
    }

    private static Set<String> leftmost(Set<String> preceeds) {
        Set<String> hasOneOnTheRight = new HashSet<>();
        Set<String> hasOneOnTheLeft = new HashSet<>();
        for (String x : preceeds) {
            String a = x.substring(0, 1);
            String b = x.substring(1, 2);
            hasOneOnTheLeft.add(b);
            hasOneOnTheRight.add(a);
        }
        hasOneOnTheLeft.removeAll(hasOneOnTheRight);
        return hasOneOnTheLeft;
    }

    private Problem79() {
    }
}
