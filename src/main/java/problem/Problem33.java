package problem;

import utils.Fraction;
import utils.SimpleFraction;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

import static problem.Solution.problem;

public class Problem33 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=33
        problem("Digit cancelling fractions",
                () -> productOfDenominatorsOfDigitCancellingFractions().map(Objects::toString).orElse("Not found"));
    }

    static Optional<Long> productOfDenominatorsOfDigitCancellingFractions() {
        return IntStream.rangeClosed(10, 99).boxed().flatMap(i ->
                        IntStream.rangeClosed(i + 1, 99).mapToObj(j ->
                                cancellingDigits(i, j)
                        ).flatMap(Optional::stream)
                )
                .reduce(SimpleFraction::multiply)
                .map(Fraction::denominator)
                .map(BigInteger::longValueExact);
    }

    static Optional<SimpleFraction> cancellingDigits(int n, int d) {
        int nLeft = n / 10;
        int nRight = n % 10;
        int dLeft = d / 10;
        int dRight = d % 10;
        double originalQuotient = (double) n / d;

        return pairIfAccidentallyCorrect(nLeft, dLeft, nRight, dRight, originalQuotient);
    }

    private static Optional<SimpleFraction> pairIfAccidentallyCorrect(int nLeft, int dLeft, int nRight, int dRight, double originalQuotient) {
        if (!isTrivial(nRight))
            if (isAccidentallyCorrect(nRight, dLeft, nLeft, dRight, originalQuotient))
                return optionalSimpleFraction(nLeft, dRight);

        return Optional.empty();
    }

    private static Optional<SimpleFraction> optionalSimpleFraction(int nRight, int dRight) {
        return Optional.of(SimpleFraction.of(nRight, dRight));
    }

    private static boolean isTrivial(int i) {
        return i == 0;
    }

    private static boolean isAccidentallyCorrect(
            int nCommon, int dCommon, int nRemaining, int dRemaining, double originalQuotient) {
        return nCommon == dCommon && ((double) nRemaining / dRemaining - originalQuotient == 0);
    }

    private Problem33() {}
}
