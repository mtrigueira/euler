package utils.data;

import java.math.BigInteger;
import java.util.List;
import java.util.OptionalInt;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static utils.operator.BigComparisonOperator.equal;

public class Layer {
    public static Layer of(long layer) {
        return new Layer(layer);
    }

    private final BigInteger layer;

    private Layer(long layer) {
        this.layer = BigInteger.valueOf(layer);
    }

    public static OptionalInt layersInGridOfSizeNxN(int n) {
        int layers = (n + 1) / 2;

        if (layers * 2 - 1 != n)
            return OptionalInt.empty();

        return OptionalInt.of(layers);
    }

    public BigInteger lengthOfSide() {
        return TWO.multiply(layer.subtract(ONE)).add(ONE);
    }

    public List<BigInteger> corners() {
        if (equal(ONE,layer)) return List.of(ONE);
        BigInteger offset = lengthOfSide().subtract(ONE);

        BigInteger NE_corner = TWO.multiply(layer).subtract(ONE).pow(2);
        BigInteger NW_corner = NE_corner.subtract(offset);
        BigInteger SW_corner = NW_corner.subtract(offset);
        BigInteger SE_corner = SW_corner.subtract(offset);

        return List.of(NE_corner, NW_corner, SW_corner, SE_corner);
    }
}
