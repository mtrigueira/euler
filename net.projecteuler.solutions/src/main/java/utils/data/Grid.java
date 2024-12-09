package utils.data;

import java.util.Formatter;

public class Grid {
    private static final int INVALID_CELL = Integer.MAX_VALUE;
    private final short[][] grid;
    private final int rows;
    private final int columns;

    public static Grid of(short[][] grid) {
        return new Grid(grid);
    }

    private static String toString(int[][] grid) {
        Formatter formatter = new Formatter();
        for (int[] shorts : grid) {
            for (int aShort : shorts) {
                formatter.format("%10d", aShort);
            }
            formatter.format("\n");
        }
        return formatter.toString();
    }

    private int[][] gridOfMinSums() {
        int[][] gridOfMinSums = new int[rows][columns];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                gridOfMinSums[i][j] = sum(i, j, gridOfMinSums);
            }
        }
        return gridOfMinSums;
    }

    private int sum(int r, int c, int[][] gridOfMinSums) {
        int right = (r + 1 >= rows) ? INVALID_CELL : gridOfMinSums[r + 1][c];
        int down = (c + 1 < columns) ? gridOfMinSums[r][c + 1] : INVALID_CELL;

        return (right == INVALID_CELL) && (down == INVALID_CELL) ? grid[r][c] : grid[r][c] + Math.min(right, down);
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
        if (cells < 1) return 0;
        if (rows == 0) return 0;
        int max = 0;

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                max = Math.max(max, maxProduct(r, c, cells));

        return max;
    }

    public long findMinPathSum() {
        return gridOfMinSums()[0][0];
    }

    private int maxProduct(int r, int c, int cells) {
        return new GridProduct(grid, r, c, cells).max();
    }

    @Override
    public String toString() {
        int[][] g2 = shortGridToIntGrid(grid);
        return toString(g2);
    }

    private Grid(short[][] grid) {
        this.grid = grid;
        rows = grid.length;
        columns = (rows > 0) ? grid[0].length : 0;
    }
}
