package problem.no61to70;

import utils.sequence.given.CombinationSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static problem.Solution.problem;

public class Problem68 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=68
        problem("Magic 5-gon ring", () ->
                maximumNgonString(5, 16));
    }

    static String maximumNgonString(int n, int digitNumberFilter) {
        List<String> elements = new ArrayList<>(n * 2);
        for (int i = 0; i < n * 2; i++)
            elements.add("" + (i + 1));

        CombinationSequence<String> combinations =
                new CombinationSequence<>(elements,
                        (a, b) -> a + "," + b);

        return combinations.stream()
                .map(Problem68::makeRing)
                .filter(Problem68::isMagicRing)
                .map(Problem68::sortRing)
                .distinct()
                .map(a -> Arrays.stream(a)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining()))
                .filter(s -> s.length() == digitNumberFilter)
                .max(Comparator.naturalOrder())
                .orElse("Not found");
    }

    static int[] sortRing(int[] elements) {
        int n = elements.length / 3;
        int[][] groups = new int[n][3];

        for (int i = 0; i < n; i++) {
            groups[i][0] = elements[i * 3];
            groups[i][1] = elements[i * 3 + 1];
            groups[i][2] = elements[i * 3 + 2];
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++)
            if (compareGroups(groups[i], groups[minIndex]) < 0)
                minIndex = i;

        for (int i = 0; i < minIndex; i++) {
            int[] temp = groups[0];
            for (int j = 1; j < groups.length; j++)
                groups[j - 1] = groups[j];
            groups[groups.length - 1] = temp;
        }

        return Arrays.stream(groups).flatMapToInt(Arrays::stream).toArray();
    }

    static int compareGroups(int[] elements, int[] minElements) {
        for (int i = 0; i < elements.length; i++) {
            int left = elements[i];
            int right = minElements[i];
            if (left != right)
                return left - right;
        }
        return 0;
    }

    static int[] makeRing(String s) {
        String[] elements = s.split(",");
        int n = elements.length / 2;
        int length = n * 3;
        int[] ring = new int[length];

        for (int i = 0; i < length; i++) {
            int j = i;
            j -= (i - 1) / 3;
            if (i > 1)
                if ((i - 1) % 3 == 0) j -= 1;

            if (i == length - 1) j = 1;
            ring[i] = Integer.parseInt(elements[j]);
        }

        return ring;
    }

    static boolean isMagicRing(int[] elements) {
        int n = elements.length / 3;
        int total = 0;

        for (int i = 0; i < n; i++)
            if (i == 0)
                total = sum(elements, i);
            else if (total != sum(elements, i))
                return false;

        return true;
    }

    private static int sum(int[] elements, int i) {
        return elements[i * 3] + elements[i * 3 + 1] + elements[i * 3 + 2];
    }
}
