package utils.data;

import java.util.Formatter;

public class Grid {
    static final int INVALID_CELL = Integer.MAX_VALUE;
    final short[][] grid;
    final int rows;
    final int columns;

    public static Grid of(short[][] grid) {
        return new Grid(grid);
    }

    static String toString(int[][] grid) {
        Formatter formatter = new Formatter();
        for (int[] rows : grid) {
            for (int cell : rows) {
                formatter.format("%12d", cell);
            }
            formatter.format("\n");
        }
        return formatter.toString();
    }

    private static int[][] shortGridToIntGrid(short[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] g2 = new int[rows][columns];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                g2[i][j] = grid[i][j];

        return g2;
    }

    public int findMaxProduct(int cells) {
        if (cells < 1)
            return 0;
        if (rows == 0)
            return 0;
        int max = 0;

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                max = Math.max(max, maxProduct(r, c, cells));

        return max;
    }

    public long findMinPathSum() {
        return new GridSumTwoWays(this).gridOfMinSums()[0][0];
    }

    private int maxProduct(int r, int c, int cells) {
        return new GridProduct(grid, r, c, cells).max();
    }

    @Override
    public String toString() {
        int[][] g2 = shortGridToIntGrid(grid);
        return toString(g2);
    }

    public long findMinPathSumThreeWays() {
        int[][] grid = new GridSumThreeWays(this).gridOfMinSums();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++)
            if (grid[i][0] < min)
                min = grid[i][0];

        return min;
    }

    public long findMinPathSumFourWays() {
        if (this.columns == 0)
            return 0;
        return new GridSumFourWays(this).gridOfMinSums()[rows - 1][columns - 1];
    }

    private Grid(short[][] grid) {
        this.grid = grid;
        rows = grid.length;
        columns = (rows > 0) ? grid[0].length : 0;
    }
}
