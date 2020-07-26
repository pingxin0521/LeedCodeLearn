package leetcode.week04.day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例：
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * <p>
 * 解题思路：
 * 我们遍历整个二维数组，当我们遇到为'1'的，我们将其相邻的所有‘1’重置为‘0’，即将这一块岛全部都变为海水然后再去遍历数组剩下的部分。遇到一个岛屿的第一标‘1’的cnt加1。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day03
 * hyp create at 20-6-21
 **/
public class NumIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = 0;
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            i = data[0];
            j = data[1];
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                queue.offer(new int[]{i - 1, j});
                grid[i - 1][j] = 0;
            }
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                queue.offer(new int[]{i + 1, j});
                grid[i + 1][j] = 0;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                queue.offer(new int[]{i, j - 1});
                grid[i][j - 1] = 0;
            }
            if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
                queue.offer(new int[]{i, j + 1});
                grid[i][j + 1] = 0;
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (grid == null || (i < 0 || i >= grid.length) || (j < 0 || j >= grid[i].length)) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }

}
