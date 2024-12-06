package problem.no41to50;

import utils.polyagonal.Polygonal;
import utils.sequence.arithmetic.PolygonalSequence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static problem.Solution.problem;
import static utils.polyagonal.Polygonal.PENTAGONAL;

public class Problem44 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=44
        problem("Pentagonal numbers",
                () -> minimumDifferenceForPolygonalPairs(PENTAGONAL));
    }

    static BigInteger minimumDifferenceForPolygonalPairs(Polygonal polygonal) {
        PolygonalSequence seq = new PolygonalSequence(polygonal);
        List<BigInteger> polygonals = new ArrayList<>();

        while (true) {
            BigInteger next = seq.next();

            for (BigInteger k : polygonals) {
                BigInteger difference = next.subtract(k);

                if (polygonal.is(difference)) {
                    BigInteger sum = k.add(next);
                    if (polygonal.is(sum))
                        return difference;
                }
            }

            polygonals.add(next);
        }
    }

    private Problem44() {
    }
}
