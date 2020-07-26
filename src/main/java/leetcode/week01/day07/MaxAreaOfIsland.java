package leetcode.week01.day07;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day07
 * hyp create at 20-3-18
 **/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            int n = grid[i].length;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }

        return res;
    }

    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;
    }


}
