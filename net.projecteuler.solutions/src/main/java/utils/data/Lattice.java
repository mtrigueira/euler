package utils.data;

import java.util.stream.IntStream;

public class Lattice {
    private final int n;
    private final long[][] lattice;

    private Lattice(int n) {
        this.n = n;
        this.lattice = createStartingLattice(n);
    }

    static long[][] createStartingLattice(int n) {
        long[][] lattice = new long[n + 1][n + 1];

        IntStream.rangeClosed(0, n)
                .forEach(i -> lattice[0][i] = lattice[i][0] = 1);

        // The lattice is symmetrical along the dexter diagonal (NW-SE),
        // This might be useful for future optimization if needed
        for (int j = 1; j <= n; j++)
            for (int i = j; i <= n; i++) {
                lattice[j][i] = lattice[j - 1][i] + lattice[j][i - 1];
                lattice[i][j] = lattice[i][j - 1] + lattice[i - 1][j];
            }

        return lattice;
    }

    public static Lattice createLattice(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n must be greater than 0");

        return new Lattice(n);
    }

    public long countRoutes() {
        return lattice[n][n];
    }
}
