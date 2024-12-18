package utils.data;

public class GridSumThreeWays extends GridSum {
    public GridSumThreeWays(Grid grid) {
        super(grid);
    }

    int[][] gridOfMinSums() {
        int[][] gridOfMinSums = new int[grid.rows][grid.columns];

        for (int r = grid.rows - 1; r >= 0; r--)
            gridOfMinSums[r][grid.columns - 1] = grid.grid[r][grid.columns - 1];

        for (int c = grid.columns - 2; c >= 0; c--) {
            for (int r = grid.rows - 1; r >= 0; r--)
                gridOfMinSums[r][c] = grid.grid[r][c] + gridOfMinSums[r][c + 1];

            boolean change = true;
            while (change) {
                change =false;
                for (int r = grid.rows - 1; r >= 0; r--) {
                    int newValue = sum(r, c, gridOfMinSums);
                    if(newValue!=gridOfMinSums[r][c]) {
                        gridOfMinSums[r][c] = newValue;
                        change=true;
                    }
                }
            }
        }

        System.out.println(Grid.toString(gridOfMinSums));
        return gridOfMinSums;
    }

    private int sum(int r, int c, int[][] gridOfMinSums) {
        int up;
        if (r - 1 < 0)
            up = Grid.INVALID_CELL;
        else
            up = grid.grid[r][c] + gridOfMinSums[r - 1][c];

        int right = gridOfMinSums[r][c];

        int down;
        if (r + 1 >= grid.rows)
            down = Grid.INVALID_CELL;
        else
            down = grid.grid[r][c] + gridOfMinSums[r + 1][c];

        return Math.min(Math.min(up, down), right);
    }
}
