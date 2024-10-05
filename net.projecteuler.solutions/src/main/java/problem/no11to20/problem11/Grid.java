package problem.no11to20.problem11;

class Grid {
    static Grid of(short[][] grid) {
        return new Grid(grid);
    }

    private final short[][] grid;
    private final int rows;
    private final int columns;
    private Grid(short[][] grid) {
        this.grid = grid;
        rows = grid.length;
        columns = (rows>0)?grid[0].length:0;
    }

    int findMaxProduct(int cells) {
        if (cells < 1) return 0;
        if (rows == 0) return 0;
        int max = 0;

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                max = Math.max(max, maxProduct(r, c, cells));

        return max;
    }

    private int maxProduct(int r, int c, int cells) {
        return new GridProduct(grid, r, c, cells).max();
    }
}
