package problem.no11to20;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem15 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=15
        problem("Lattice paths");
        solution(count(20));
    }

    public static long count(int i) {
        return new Problem15(i).count();
    }

    private final int n;
    private final long[][] lattice;
    private Problem15(int n) {
        this.n = n;
        lattice = createStartingLattice(n);
    }

    private long count() {
        if (n < 1) return 0;

        // The lattice is symmetrical along the dexter diagonal (NW-SE),
        // This might be useful for future optimization if needed
        for (int j = 1; j <= n; j++)
            for (int i = j; i <= n; i++) {
                lattice[j][i] = lattice[j - 1][i] + lattice[j][i - 1];
                lattice[i][j] = lattice[i][j - 1] + lattice[i - 1][j];
            }

        return lattice[n][n];
    }

    private long[][] createStartingLattice(int n) {
        long[][] lattice = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++)
            lattice[0][i] = lattice[i][0] = 1;

        return lattice;
    }
}
