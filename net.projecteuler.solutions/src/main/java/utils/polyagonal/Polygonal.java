package utils.polyagonal;

import java.math.BigInteger;
import java.util.List;

import static utils.BigIntegerConstants.*;

public class Polygonal {
    public static final Polygonal TRIANGULAR = new Polygonal(BigInteger.valueOf(3), "Triangular");
    public static final Polygonal SQUARE = new Polygonal(BigInteger.valueOf(4), "Square");
    public static final Polygonal PENTAGONAL = new Polygonal(BigInteger.valueOf(5), "Pentagonal");
    public static final Polygonal HEXAGONAL = new Polygonal(BigInteger.valueOf(6), "Hexagonal");
    public static final Polygonal HEPTAGONAL = new Polygonal(BigInteger.valueOf(7), "Heptagonal");
    public static final Polygonal OCTAGONAL = new Polygonal(BigInteger.valueOf(8), "Octagonal");
    public static final List<Polygonal> POLYGONALS = List.of(TRIANGULAR, SQUARE, PENTAGONAL, HEXAGONAL, HEPTAGONAL, OCTAGONAL);

    private final BigInteger sides;
    private final BigInteger sMinus2;
    private final BigInteger sMinus4;
    private final BigInteger sMinus4Squared;
    private final String name;
    private final BigInteger twoMultiplySMinus2;

    Polygonal(BigInteger sides, String name) {
        this.name = name;
        if (sides == null)
            throw new IllegalArgumentException("sides cannot be null");
        this.sides = sides;
        this.sMinus2 = this.sides.subtract(TWO);
        this.sMinus4 = this.sides.subtract(FOUR);
        sMinus4Squared = sMinus4.multiply(sMinus4);
        twoMultiplySMinus2 = TWO.multiply(sMinus2);
    }

    public boolean is(BigInteger x) {
        return at(indexOf(x)).equals(x);
    }

    private BigInteger indexOf(BigInteger x) {
        return ((x.multiply(sMinus2.multiply(EIGHT)).add(sMinus4Squared))
                .sqrt().add(sMinus4)).divide(twoMultiplySMinus2);
    }

    public BigInteger at(BigInteger n) {
        return sMinus2.multiply(n.multiply(n)).subtract(sMinus4.multiply(n)).divide(TWO);
    }

    @Override
    public String toString() {
        return name.isEmpty() ? "Polygonal{" +
                "sides=" + sides +
                '}' : name;
    }
}
