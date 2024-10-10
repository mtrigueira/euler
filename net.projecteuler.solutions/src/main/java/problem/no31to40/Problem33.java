package problem.no31to40;

import utils.Fraction;
import utils.SimpleFraction;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class Problem33 {
    public static void main(String[] args) {
        ArrayList<SimpleFraction> simpleFractions = new ArrayList<>();
        for (int i = 10; i <= 98; i++)
            for (int j = i + 1; j <= 99; j++)
                cancellingDigits(i, j).ifPresent(simpleFractions::add);

        Optional<Integer> productDenominator = getProductDenominator(simpleFractions);

        System.out.println(productDenominator.map(Objects::toString).orElse("Not found"));
    }

    private static Optional<Integer> getProductDenominator(ArrayList<SimpleFraction> simpleFractions) {
        return simpleFractions.stream()
                .map(SimpleFraction::simplify)
                .reduce(SimpleFraction::multiply)
                .map(SimpleFraction::simplify)
                .map(Fraction::denominator);
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
        if (isAccidentallyCorrect(nLeft, dLeft, nRight, dRight, originalQuotient))
            return optionalSimpleFraction(nRight, dRight);

        if (isAccidentallyCorrect(nLeft, dRight, nRight, dLeft, originalQuotient))
            return optionalSimpleFraction(nRight, dLeft);

        if (!isTrivial(nRight)) {
            if (isAccidentallyCorrect(nRight, dLeft, nLeft, dRight, originalQuotient))
                return optionalSimpleFraction(nLeft, dRight);

            if (isAccidentallyCorrect(nRight, dRight, nLeft, dLeft, originalQuotient))
                return optionalSimpleFraction(nLeft, dLeft);
        }

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
        return nCommon == dCommon && (double) nRemaining / dRemaining == originalQuotient;
    }
}
