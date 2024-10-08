package problem.no21to30.problem26;

public class FractionStringMaker {
    public static String toString(LongDivision ld) {
        String s = ld.nextDigit() + "." + decimalsUntilTerminationOrRecursion(ld);

        if (ld.isRecurringCycle())
            s = decorateRecurringCycle(s, ld.startOfRecurringCycle());

        return s;
    }

    private static String decimalsUntilTerminationOrRecursion(LongDivision ld) {
        String s = "";

        while (!ld.isTerminated()) {
            long digit = ld.nextDigit();
            if (ld.isRecurringCycle()) break;
            s += digit;
        }

        if (s.isEmpty()) s = "0";

        return s;
    }

    private static String decorateRecurringCycle(String s, int i) {
        return s.substring(0, i + 1) + "(" + s.substring(i + 1) + ")";
    }
}
