package utils.data;

public abstract class GridSum {
    final Grid grid;

    public GridSum(Grid grid) {
        this.grid = grid;
    }

    int[][] gridOfMinSums() {
        int[][] gridOfMinSums = new int[grid.rows][grid.columns];

        for (int c = grid.columns - 1; c >= 0; c--)
            for (int r = grid.rows - 1; r >= 0; r--)
                gridOfMinSums[r][c] = sum(r, c, gridOfMinSums);

        System.out.println(Grid.toString(gridOfMinSums));
        return gridOfMinSums;
    }

    abstract int sum(int r, int c, int[][] gridOfMinSums);
}
