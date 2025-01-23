package utils.polyagonal;

import java.math.BigInteger;
import java.util.List;

import static utils.BigIntegerConstants.*;

public class Polygonal {
    public static final Polygonal TRIANGULAR = new Polygonal(3, "Triangular");
    public static final Polygonal SQUARE = new Polygonal(4, "Square");
    public static final Polygonal PENTAGONAL = new Polygonal(5, "Pentagonal");
    public static final Polygonal HEXAGONAL = new Polygonal(6, "Hexagonal");
    public static final Polygonal HEPTAGONAL = new Polygonal(7, "Heptagonal");
    public static final Polygonal OCTAGONAL = new Polygonal(8, "Octagonal");
    public static final List<Polygonal> POLYGONALS = List.of(TRIANGULAR, SQUARE, PENTAGONAL, HEXAGONAL, HEPTAGONAL, OCTAGONAL);

    private final BigInteger sMinus2;
    private final BigInteger sMinus4;
    private final BigInteger sMinus4Squared;
    private final String name;
    private final BigInteger twoMultiplySMinus2;
    private final BigInteger sMinus2multiply8;

    public boolean is(BigInteger x) {
        return at(indexOf(x)).equals(x);
    }

    private BigInteger indexOf(BigInteger x) {
        return ((x.multiply(sMinus2multiply8).add(sMinus4Squared))
                .sqrt().add(sMinus4)).divide(twoMultiplySMinus2);
    }

    public BigInteger at(BigInteger n) {
        return sMinus2.multiply(n.multiply(n)).subtract(sMinus4.multiply(n)).divide(TWO);
    }

    @Override
    public String toString() {
        return name;
    }

    private Polygonal(int sides, String name) {
        this.name = name;
        this.sMinus2 = BigInteger.valueOf(sides-2);
        this.sMinus4 = BigInteger.valueOf(sides-4);
        sMinus4Squared = sMinus4.multiply(sMinus4);
        twoMultiplySMinus2 = TWO.multiply(sMinus2);
        sMinus2multiply8 = sMinus2.multiply(EIGHT);
    }
}
