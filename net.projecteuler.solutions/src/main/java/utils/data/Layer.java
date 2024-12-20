package utils.data;

import java.util.OptionalInt;

public class Layer {
    private final long layer;

    public static Layer of(long layer) {
        return new Layer(layer);
    }

    public static OptionalInt layersInGridOfSizeNxN(int n) {
        int layers = (n + 1) / 2;

        if (layers * 2 - 1 != n)
            return OptionalInt.empty();

        return OptionalInt.of(layers);
    }

    public long lengthOfSide() {
        return 2 * (layer - 1) + 1;
    }

    public long[] corners() {
        if (layer == 1)
            return new long[]{1L};
        long offset = lengthOfSide() - 1;

        long NE_corner = (2 * layer - 1);
        NE_corner *= NE_corner;
        long NW_corner = NE_corner - offset;
        long SW_corner = NW_corner - offset;
        long SE_corner = SW_corner - offset;

        return new long[]{NE_corner, NW_corner, SW_corner, SE_corner};
    }

    private Layer(long layer) {
        this.layer = layer;
    }
}
