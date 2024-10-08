package problem.no31to40.problem33;

import utils.Fraction;
import utils.SimpleFraction;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class DigitCancellingFractions {
    public static void main(String[] args) {
        ArrayList<SimpleFraction> simpleFractions = new ArrayList<>();
        for (int i = 10; i <= 98; i++)
            for (int j = i + 1; j <= 99; j++)
                cancellingDigits(i, j).ifPresent(simpleFractions::add);

        Optional<Integer> productDenominator = simpleFractions.stream()
                .map(SimpleFraction::simplify)
                .reduce(SimpleFraction::multiply)
                .map(SimpleFraction::simplify)
                .map(Fraction::denominator);

        System.out.println(productDenominator.map(Objects::toString).orElse("Not found"));
    }

    private static Optional<SimpleFraction> cancellingDigits(int n, int d) {
        int nLeft = n / 10;
        int nRight = n % 10;
        int dLeft = d / 10;
        int dRight = d % 10;
        double originalQuotient = (double) n / d;

        return pairIfAccidentallyCorrect(nLeft, dLeft, nRight, dRight, originalQuotient);
    }

    private static Optional<SimpleFraction> pairIfAccidentallyCorrect(int nLeft, int dLeft, int nRight, int dRight, double originalQuotient) {
        if (isAccidentiallyCorrect(nLeft, dLeft, nRight, dRight, originalQuotient))
            return Optional.of(SimpleFraction.of(nRight, dRight));

        if (isAccidentiallyCorrect(nLeft, dRight, nRight, dLeft, originalQuotient))
            return Optional.of(SimpleFraction.of(nRight, dLeft));

        if (!isTrivial(nRight)) {
            if (isAccidentiallyCorrect(nRight, dLeft, nLeft, dRight, originalQuotient))
                return Optional.of(SimpleFraction.of(nLeft, dRight));

            if (isAccidentiallyCorrect(nRight, dRight, nLeft, dLeft, originalQuotient))
                return Optional.of(SimpleFraction.of(nLeft, dLeft));
        }

        return Optional.empty();
    }

    private static boolean isTrivial(int nRight) {
        return nRight == 0;
    }

    private static boolean isAccidentiallyCorrect(
            int nCommon, int dCommon, int nRemaining, int dRemaining, double originalQuotient) {
        return nCommon == dCommon && (double) nRemaining / dRemaining == originalQuotient;
    }
}
