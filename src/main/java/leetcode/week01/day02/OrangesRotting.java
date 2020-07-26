package leetcode.week01.day02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/rotting-oranges/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class OrangesRotting {
    /**
     * https://leetcode-cn.com/problems/rotting-oranges/solution/li-qing-si-lu-wei-shi-yao-yong-bfsyi-ji-ru-he-xie-/
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int count = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0; // round 表示腐烂的轮数，或者分钟数
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count--;
                    queue.add(new int[]{r - 1, c});
                }
                if (r + 1 < M && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    queue.add(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    count--;
                    queue.add(new int[]{r, c - 1});
                }
                if (c + 1 < N && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    count--;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }

        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
}
