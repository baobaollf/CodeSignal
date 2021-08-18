package Arrays;

public class sudoku2 {
    // time: O(n)
    // space: O(1)
    boolean sudoku2(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            boolean[] seenRow = new boolean[grid.length];
            boolean[] seenCol = new boolean[grid.length];
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] >= '1' && grid[i][j] <= '9') {
                    if (seenRow[grid[i][j] - '1']) {
                        return false;
                    }
                    seenRow[grid[i][j] - '1'] = true;
                }

                if (grid[j][i] >= '1' && grid[j][i] <= '9') {
                    if (seenCol[grid[j][i] - '1']) {
                        return false;
                    }
                    seenCol[grid[j][i] - '1'] = true;
                }
            }
        }

        for (int i = 0; i < grid.length; i += 3) {
            for (int j = 0; j < grid.length; j += 3) {
                if (!check(grid, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // is the 3 * 3 box valid
    private boolean check(char[][] grid, int i, int j) {
        boolean[] seen = new boolean[grid.length];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (grid[i + x][j + y] >= '1' && grid[i + x][j + y] <= '9') {
                    if (seen[grid[i + x][j + y] - '1']) {
                        return false;
                    }
                    seen[grid[i + x][j + y] - '1'] = true;
                }
            }
        }
        return true;
    }


}
