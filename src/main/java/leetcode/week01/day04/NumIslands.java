package leetcode.week01.day04;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class NumIslands {

    public int numIslands(char[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    c++;
                }
            }
        }
        return c;
    }

    private void dfs(char[][] grid, int r, int c) {
        grid[r][c] = 0;
        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
            dfs(grid, r - 1, c);
        }
        if (r + 1 < grid.length && grid[r + 1][c] == '1') {
            dfs(grid, r + 1, c);
        }
        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
            dfs(grid, r, c - 1);
        }
        if (c + 1 < grid[r].length && grid[r][c + 1] == '1') {
            dfs(grid, r, c + 1);
        }
    }


}
