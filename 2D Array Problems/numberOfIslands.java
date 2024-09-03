public class numberOfIslands {
    static void DFS(int grid[][], int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            DFS(grid, i - 1, j, row, col);
            DFS(grid, i + 1, j, row, col);
            DFS(grid, i, j - 1, row, col);
            DFS(grid, i, j + 1, row, col);
        }
    }

    static int count(int grid[][]) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    DFS(grid, i, j, row, col);

                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 } };

        System.out.println(count(grid));

    }
}