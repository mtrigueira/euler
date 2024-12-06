package utils.data;

import java.util.Formatter;

public class Grid {
    private final short[][] grid;
    private final int rows;
    private final int columns;

    public static Grid of(short[][] grid) {
        return new Grid(grid);
    }

    private static String toString(short[][] grid) {
        Formatter formatter = new Formatter();
        for (short[] shorts : grid) {
            for (short aShort : shorts) {
                formatter.format("%10d", aShort);
            }
            formatter.format("\n");
        }
        return formatter.toString();
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
        long sum = 0;
        int r = rows - 1;
        int c = columns - 1;

        while ((r > 0) && (c > 0)) {
            sum += grid[r][c];
            if (grid[r - 1][c] > grid[r][c - 1])
                c--;
            else
                r--;
        }
        sum += grid[r][c];
        if (c == 0)
            while (r-- > 0) sum += grid[r][c];
        else
            while (c-- > 0) sum += grid[r][c];

        return sum;
    }

    private int maxProduct(int r, int c, int cells) {
        return new GridProduct(grid, r, c, cells).max();
    }

    @Override
    public String toString() {
        return toString(grid);
    }

    private Grid(short[][] grid) {
        this.grid = grid;
        rows = grid.length;
        columns = (rows > 0) ? grid[0].length : 0;
    }
}
