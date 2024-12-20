package problem.no81to90;

import utils.FileUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static problem.Solution.problem;
import static problem.no81to90.RomanDigitFrequency.MULTIPLE_ALLOWED;
import static problem.no81to90.RomanDigitFrequency.ONLY_ONCE;
import static utils.FileUtils.concat;

enum RomanDigitFrequency {ONLY_ONCE, MULTIPLE_ALLOWED}

public class Problem89 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=89
        problem("Roman numerals", Problem89::solution);
    }

    private static int solution() {
        Stream<String> strings = concat(FileUtils.getStrings("/0089_roman.txt"),
                "XIIIIII\nM\nCM\nD\nCD\nC\nXC\nL\nXL\nIX\nIV\nI\n");
        return strings
                .mapToInt(roman -> roman.length() - Roman.parseRoman(roman).toString().length())
                .sum();
    }

    private Problem89() {
    }
}

class RomanDigit implements Comparable<RomanDigit> {
    static final Map<String, RomanDigit> digits = new HashMap<>();
    static final RomanDigit M = new RomanDigit("M", 1000);

    static {
        new RomanDigit("I", 1);
        new RomanDigit("IV", 4);
        new RomanDigit("V", 5, ONLY_ONCE);
        new RomanDigit("IX", 9);
        new RomanDigit("X", 10);
        new RomanDigit("XL", 40);
        new RomanDigit("L", 50, ONLY_ONCE);
        new RomanDigit("XC", 90);
        new RomanDigit("C", 100);
        new RomanDigit("CD", 400);
        new RomanDigit("D", 500, ONLY_ONCE);
        new RomanDigit("CM", 900);
    }

    private final String c;
    private final int i;
    private final RomanDigitFrequency romanDigitFrequency;

    public static RomanDigit romanDigit(String c) {
        return Optional.ofNullable(digits.get(c)).orElseThrow(() -> new NumberFormatException("Problem with digit: " + c));
    }

    public static RomanDigit getMaxFactor(int i) {
        return digits.values().stream().sorted()
                .takeWhile(d -> d.i <= i)
                .max(RomanDigit::compareTo)
                .orElse(M);
    }

    public int times(int x) throws NumberFormatException {
        if (x > 1 && ONLY_ONCE.equals(romanDigitFrequency))
            throw new NumberFormatException("Digit can only occur once: " + c);

        return i * x;
    }

    @Override
    public String toString() {
        return c;
    }

    @Override
    public int compareTo(RomanDigit other) {
        return Integer.compare(this.i, other.i);
    }

    private RomanDigit(String c, int i) {
        this(c, i, MULTIPLE_ALLOWED);
    }

    private RomanDigit(String c, int i, RomanDigitFrequency romanDigitFrequency) {
        this.c = c;
        this.i = i;
        this.romanDigitFrequency = romanDigitFrequency;
        digits.put(c, this);
    }
}

class Roman {
    private final int i;

    public static Roman parseRoman(String s) throws NumberFormatException {
        int value = 0;

        StringBuilder sb = new StringBuilder(s);
        RomanDigit left = null;
        int leftCount = 0;
        while (!sb.isEmpty()) {
            char c = sb.charAt(0);
            int rightCount = 0;
            while (!sb.isEmpty() && sb.charAt(0) == c) {
                sb.deleteCharAt(0);
                rightCount++;
            }
            RomanDigit right = RomanDigit.romanDigit(c + "");
            if (left != null)
                if (left.compareTo(right) < 0) {
                    if (leftCount == 1) {
                        //   validate it is a permitted combination
                        value -= left.times(2);
                    } else
                        throw new NumberFormatException("Subtractive may only have one occurrence");

                }

            value += right.times(rightCount);

            left = right;
            leftCount = rightCount;
        }

        return new Roman(value);
    }

    public int intValue() {
        return i;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int r = i;
        while (r > 0) {
            RomanDigit romanDigit = RomanDigit.getMaxFactor(r);
            r -= romanDigit.times(1);
            sb.append(romanDigit);
        }
        return sb.toString();
    }

    private Roman(int i) {
        this.i = i;
    }
}