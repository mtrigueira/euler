package problem.no71to80;

import static problem.Solution.problem;

public class Problem71 {
    private Problem71() {}

    public static void main(String[] args) {
        // https://projecteuler.net/problem=71
        problem("Ordered fractions", () ->
                orderedFractionToLeftOfWhere(3, 7, 1_000_000));
    }

    static int orderedFractionToLeftOfWhere(int rightN, int rightD, int i) {
        int numerator = 0;
        int denominator = 1;
        int leftN = 0;
        int leftD = 1;

        while (denominator <= i) {
            if (numerator * rightD < rightN * denominator)
                numerator++;
            else
                denominator++;

            if (numerator * rightD < rightN * denominator)
                if (leftN * denominator < numerator * leftD) {
                    leftN = numerator;
                    leftD = denominator;
                }
        }

        return leftN;
    }
}
