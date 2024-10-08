package problem.no31to40.problem33;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class DigitCancellingFractions {
    public static void main(String[] args) {
        ArrayList<Pair> fractions = new ArrayList<>();
        for (int i = 10; i <= 98; i++)
            for (int j = i + 1; j <= 99; j++) {
                Pair pair = cancellingDigits(i, j);
                if (!EMPTY.equals(pair))
                    fractions.add(pair);
            }

        Optional<Integer> productDenominator = fractions.stream().map(Pair::simplify).reduce(Pair::multiply).map(f -> f.d);

        System.out.println(productDenominator.map(Objects::toString).orElse("Not found"));
    }

    private static Pair cancellingDigits(int n, int d) {
        int nLeft = n / 10;
        int nRight = n % 10;
        int dLeft = d / 10;
        int dRight = d % 10;
        double originalQuotient = (double) n / d;

        return pairIfAccidentallyCorrect(nLeft, dLeft, nRight, dRight, originalQuotient);
    }

    private static Pair pairIfAccidentallyCorrect(int nLeft, int dLeft, int nRight, int dRight, double originalQuotient) {
        if (isAccidentiallyCorrect(nLeft, dLeft, nRight, dRight, originalQuotient))
            return new Pair(nRight, dRight);

        if (isAccidentiallyCorrect(nLeft, dRight, nRight, dLeft, originalQuotient))
            return new Pair(nRight, dLeft);

        if (!isTrivial(nRight)) {
            if (isAccidentiallyCorrect(nRight, dLeft, nLeft, dRight, originalQuotient))
                return new Pair(nLeft, dRight);

            if (isAccidentiallyCorrect(nRight, dRight, nLeft, dLeft, originalQuotient))
                return new Pair(nLeft, dLeft);
        }

        return EMPTY;
    }

    private static boolean isTrivial(int nRight) {
        return nRight == 0;
    }

    private static boolean isAccidentiallyCorrect(
            int nCommon, int dCommon, int nRemaining, int dRemaining, double originalQuotient) {
        return nCommon == dCommon && (double) nRemaining / dRemaining == originalQuotient;
    }

    private record Pair(int n, int d) {
        private static Pair simplify(Pair f) {
            if (f.n == f.d) return new Pair(1, 1);
            int gcd = gcd(f.n, f.d);
            return new Pair(f.n / gcd, f.d / gcd);
        }

        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        @Override
        public String toString() {
            return n + "/" + d;
        }

        public Pair multiply(Pair by) {
            int newN = this.n * by.n;
            int newD = this.d * by.d;
            int gcd = gcd(newN, newD);
            return new Pair(newN / gcd, newD / gcd);
        }
    }

    private static final Pair EMPTY = new Pair(0, 0);
}
