package problem;

import utils.polyagonal.Polygonal;
import utils.sequence.arithmetic.PolygonalSequence;

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

    static long minimumDifferenceForPolygonalPairs(Polygonal polygonal) {
        PolygonalSequence seq = new PolygonalSequence(polygonal);
        List<Long> polygonals = new ArrayList<>();

        while (true) {
            Long next = seq.next();

            for (Long k : polygonals) {
                long difference = next-(k);

                if (polygonal.is(difference)) {
                    long sum = k + next;
                    if (polygonal.is(sum))
                        return difference;
                }
            }

            polygonals.add(next);
        }
    }

    private Problem44() {}
}
