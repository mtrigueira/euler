package problem.no21to30.problem28;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static utils.operator.BigComparisonOperator.equal;

class Layer {
    static Layer of(long layer) {
        return new Layer(layer);
    }

    private final BigInteger layer;

    private Layer(long layer) {
        this.layer = BigInteger.valueOf(layer);
    }

    BigInteger lengthOfSide() {
        return TWO.multiply(layer.subtract(ONE)).add(ONE);
    }

    BigInteger sumOfCorners() {
        if (equal(ONE,layer)) return ONE;
        BigInteger offset = lengthOfSide().subtract(ONE);

        BigInteger NE_corner = TWO.multiply(layer).subtract(ONE).pow(2);
        BigInteger NW_corner = NE_corner.subtract(offset);
        BigInteger SW_corner = NW_corner.subtract(offset);
        BigInteger SE_corner = SW_corner.subtract(offset);

        return SE_corner.add(SW_corner).add(NW_corner).add(NE_corner);
    }
}
