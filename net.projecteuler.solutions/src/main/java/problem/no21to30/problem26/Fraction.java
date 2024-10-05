package problem.no21to30.problem26;

class Fraction {
    public static Fraction of(int numerator, int denominator) {
        LongDivision ld = LongDivision.of(numerator, denominator);

        return new Fraction(FractionStringMaker.toString(ld));
    }

    private final String n;
    private final int reciprocalLength;

    private Fraction(String n) {
        this.n = n;
        reciprocalLength = n.contains("(") ? n.indexOf(")") - n.indexOf("(") : 0;
    }

    boolean isReciprocalCycle() {
        return reciprocalLength > 0;
    }

    int reciprocalLength() {
        return reciprocalLength;
    }

    @Override
    public String toString() {
        return n;
    }
}

