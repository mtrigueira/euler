package problem;

import utils.data.Layer;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static problem.Solution.problem;

public class Problem28 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=28
        problem("Number spiral diagonals",
                () -> sumOfDiagonalsInAGridOfSizeNxN(1001));
    }

    static long sumOfDiagonalsInAGridOfSizeNxN(int n) {
        return sumOfDiagonalsInAGridOfNLayers(Layer.layersInGridOfSizeNxN(n).orElseThrow());
    }

    private static long sumOfDiagonalsInAGridOfNLayers(int layers) {
        return IntStream.rangeClosed(1, layers)
                .mapToObj(Layer::of)
                .map(Layer::corners)
                .map(LongStream::of)
                .flatMapToLong(a -> a)
                .reduce(0L, Long::sum);
    }

    private Problem28() {}
}

