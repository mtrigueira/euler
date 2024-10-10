package utils.data;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static utils.operator.BigComparisonOperator.equal;

public class Layer {
    public static Layer of(long layer) {
        return new Layer(layer);
    }

    private final BigInteger layer;

    private Layer(long layer) {
        this.layer = BigInteger.valueOf(layer);
    }

    public BigInteger lengthOfSide() {
        return TWO.multiply(layer.subtract(ONE)).add(ONE);
    }

    public BigInteger sumOfCorners() {
        if (equal(ONE,layer)) return ONE;
        BigInteger offset = lengthOfSide().subtract(ONE);

        BigInteger NE_corner = TWO.multiply(layer).subtract(ONE).pow(2);
        BigInteger NW_corner = NE_corner.subtract(offset);
        BigInteger SW_corner = NW_corner.subtract(offset);
        BigInteger SE_corner = SW_corner.subtract(offset);

        return SE_corner.add(SW_corner).add(NW_corner).add(NE_corner);
    }
}
