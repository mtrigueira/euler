package problem.no91to100;

import utils.FileUtils;

import java.util.*;
import java.util.stream.Stream;

import static problem.Solution.problem;

public class Problem98 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=
        problem("Anagramic squares", () ->
                solution(WORDS));
    }

    public static final Stream<String> WORDS = FileUtils.concat(FileUtils.getNames("/0098_words.txt"), "REDUCTION\nINTRODUCE\nARISE\nRAISE\nTEA\nEAT\n\nPOT\nTOP\nNO\nON");

    static int solution(Stream<String> words) {
        List<Set<String>> anagramsSortedByLength = anagramsSortedByLength(words);

        for (Set<String> group : anagramsSortedByLength) {
            String[] anagrams = group.toArray(String[]::new);
            int length = anagrams[0].length();
            int tooShort = (int) Math.pow(10, length - 1);

            for (int leftSquare = (int) Math.pow(10, length) - 1;
                 leftSquare > tooShort;
                 leftSquare = lowerSquare(leftSquare))
                for (String left : anagrams)
                    if (isValid(leftSquare, left))
                        for (String right : anagrams)
                            if (!left.equals(right)) {
                                if (isSquare(crossSubstitute(leftSquare, left, right)))
                                    return leftSquare;
                            }
        }

        return -1;
    }

    private static List<Set<String>> anagramsSortedByLength(Stream<String> words) {
        Map<String, Set<String>> anagramGroups = new HashMap<>();
        words.forEach(word -> {
            String hash = sort(word);
            anagramGroups.computeIfAbsent(hash, h -> new HashSet<>()).add(word);
        });

        for (String hash : new HashSet<>(anagramGroups.keySet())) {
            if (anagramGroups.get(hash).size() == 1)
                anagramGroups.remove(hash);
        }

        return anagramGroups.values().stream().sorted((a, b) -> b.iterator().next().length() - a.iterator().next().length()).toList();
    }

    private static boolean isSquare(int d) {
        return Math.sqrt(d) % 1 == 0;
    }

    static int crossSubstitute(int i, String word, String target) {
        String s = Integer.toString(i);
        for (int j = 0; j < s.length(); j++) {
            char c = word.charAt(j);
            char d = s.charAt(j);

            target = target.replace(c, d);
        }

        return Integer.parseInt(target);
    }

    static boolean isValid(int i, String word) {
        String s = Integer.toString(i);
        if (s.contains("0"))
            return false;

        for (int j = 0; j < s.length(); j++) {
            char d = s.charAt(j);
            char c = word.charAt(j);

            s = s.replace(d, c);
        }
        return s.equals(word);
    }

    static String sort(String word) {
        return word.chars().sorted().mapToObj(Character::toString).reduce("", (a, b) -> a + b);
    }

    static int lowerSquare(int i) {
        i = i - 1;
        int sqrt = (int) Math.sqrt(i);
        return sqrt * sqrt;
    }

    private Problem98() {}
}
