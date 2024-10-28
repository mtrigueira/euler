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
    private final String name;

    Polygonal(BigInteger sides, String name) {
        this.name = name;
        if(sides==null) throw new IllegalArgumentException("sides cannot be null");
        this.sides = sides;
        this.sMinus2 = this.sides.subtract(TWO);
        this.sMinus4 = this.sides.subtract(FOUR);
    }

    public boolean is(BigInteger x) {
        BigInteger n = indexOf(x);
        BigInteger x2 = at(n);
        return x2.equals(x);
    }

    private BigInteger indexOf(BigInteger x) {
        return ((x.multiply(sMinus2.multiply(EIGHT)).add(sides.subtract(FOUR).pow(2)))
                .sqrt().add(sides.subtract(FOUR))).divide(TWO.multiply(sMinus2));
    }

    public BigInteger at(BigInteger n) {
        BigInteger nSquared = n.pow(2);
        BigInteger a = sMinus2.multiply(nSquared);
        BigInteger b = sMinus4.multiply(n);
        return a.subtract(b).divide(TWO);
    }

    @Override
    public String toString() {
        return name.isEmpty() ? "Polygonal{" +
                "sides=" + sides +
                '}' : name;
    }
}
