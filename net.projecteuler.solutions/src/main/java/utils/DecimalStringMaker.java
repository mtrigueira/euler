package utils;

public class DecimalStringMaker {
    public static String toString(LongDivision ld) {
        String s = ld.nextDigit() + "." + decimalsUntilTerminationOrRecursion(ld);

        if (ld.isRecurringCycle())
            s = decorateRecurringCycle(s, ld.startOfRecurringCycle());

        return s;
    }

    private static String decimalsUntilTerminationOrRecursion(LongDivision ld) {
        StringBuilder s = new StringBuilder();

        while (!ld.isTerminated()) {
            long digit = ld.nextDigit();
            if (ld.isRecurringCycle())
                break;
            s.append(digit);
        }

        if (s.isEmpty())
            s = new StringBuilder("0");

        return s.toString();
    }

    private static String decorateRecurringCycle(String s, int i) {
        return s.substring(0, i + 1) + "(" + s.substring(i + 1) + ")";
    }

    private DecimalStringMaker() {
    }
}
