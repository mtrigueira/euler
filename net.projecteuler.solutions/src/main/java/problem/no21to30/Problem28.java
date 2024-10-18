package problem.no21to30;

import utils.data.Layer;

import java.math.BigInteger;
import java.util.Collection;
import java.util.stream.IntStream;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem28 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=28
        problem("Number spiral diagonals");
        solution(sumOfDiagonalsInAGridOfSizeNxN(1001));
    }

    static BigInteger sumOfDiagonalsInAGridOfSizeNxN(int n) {
        return sumOfDiagonalsInAGridOfNLayers(Layer.layersInGridOfSizeNxN(n).orElseThrow());
    }

    private static BigInteger sumOfDiagonalsInAGridOfNLayers(int layers) {
        return IntStream.rangeClosed(1, layers)
                .mapToObj(Layer::of)
                .map(Layer::corners)
                .flatMap(Collection::stream)
                .reduce(ZERO,BigInteger::add);
    }
}

