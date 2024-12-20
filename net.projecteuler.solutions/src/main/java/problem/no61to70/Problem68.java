package problem.no61to70;

import utils.data.Group;
import utils.data.Ring;
import utils.sequence.given.CombinationSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static problem.Solution.problem;

public class Problem68 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=68
        problem("Magic 5-gon ring", () ->
                maximumNgonString(5, 16));
    }

    static String maximumNgonString(int n, int digitNumberFilter) {
        return groups(elements(n))
                .collect(Collectors.groupingBy(Group::sum)).entrySet().stream()
                .flatMap(e -> ringStream(n, e.getValue()))
                .map(Ring::toCompactString)
                .filter(s -> s.length() == digitNumberFilter)
                .max(Comparator.naturalOrder())
                .orElse("Not found");
    }

    private static List<String> elements(int n) {
        List<String> elements = new ArrayList<>(n * 2);

        for (int i = 0; i < n * 2; i++)
            elements.add("" + (i + 1));

        return elements;
    }

    private static Stream<Group> groups(List<String> elements) {
        return new CombinationSequence<>(elements, (a, b) -> a + "," + b, 3)
                .stream()
                .map(Group::from);
    }

    private static Stream<Ring> ringStream(int n, List<Group> e) {
        return ringStream(n, e, Ring.EMPTY)
                .filter(Ring::isRing)
                .map(Ring::sort)
                .distinct();
    }

    private static Stream<Ring> ringStream(int n, List<Group> e, Ring r) {
        if (n == 0)
            return Stream.of(r).filter(Ring::isChain).filter(Ring::isRing);

        return e.stream()
                .filter(a -> !Arrays.asList(r.groups()).contains(a))
                .map(r::append)
                .filter(Ring::isChain)
                .flatMap(ring -> ringStream(n - 1, e, ring));
    }

    private Problem68() {
    }
}
