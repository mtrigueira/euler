package utils.data;

class GridSumTwoWays extends GridSum {

    GridSumTwoWays(Grid grid) {
        super(grid);
    }

    @Override
    int sum(int r, int c, int[][] gridOfMinSums) {
        int right = (r + 1 >= grid.rows) ? Grid.INVALID_CELL : gridOfMinSums[r + 1][c];
        int down = (c + 1 < grid.columns) ? gridOfMinSums[r][c + 1] : Grid.INVALID_CELL;

        return (right == Grid.INVALID_CELL) && (down == Grid.INVALID_CELL) ? grid.grid[r][c] : grid.grid[r][c] + Math.min(right, down);
    }
}
