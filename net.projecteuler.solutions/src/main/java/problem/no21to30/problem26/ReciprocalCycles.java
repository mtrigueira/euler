package problem.no21to30.problem26;

public class ReciprocalCycles {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=26
        int max = 0;
        int maxIndex = 0;
        for (int i = 2; i < 1000; i++) {
            Fraction fraction = Fraction.of(1, i);
            if (fraction.isReciprocalCycle())
                if (fraction.reciprocalLength() > max) {
                    max = fraction.reciprocalLength();
                    maxIndex = i;
                }
        }

        System.out.println(maxIndex);
    }
}

