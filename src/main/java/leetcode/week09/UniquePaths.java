package leetcode.week09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * <p>
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePaths {
    public static void main(String[] args) {
//        System.out.println(uniquePaths(3, 7));
//        System.out.println(uniquePaths(3, 3));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1}, {0}}));

        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    /**
     * * f(i,j) = f(i-1) + f(j-1) ,i>1&&j>1
     * * f(i,1) = f(1,j) = 1
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * f(i,j) = 0 ,obstacleGrid[i,j]=1
     * f(i,j) = f(i-1) + f(j-1) ,i>1&&j>1
     * f(i,1) = f(1,j) = 1 ,i=1||j=1
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[i] = i == 0 ? 1 : dp[i - 1];
        }

        for (int i = 1; i < m; i++) {
            dp[0] = obstacleGrid[i][0] == 0 ? dp[0] : 0;
            for (int j = 1; j < dp.length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[j] = dp[j] + dp[j - 1];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[n - 1];
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> m = new ArrayList<>();
        for (int[] i : intervals) {
            int L = i[0], R = i[1];
            if (m.size() == 0 || m.get(m.size() - 1)[1] < L) {
                m.add(new int[]{L, R});
            } else {
                m.get(m.size() - 1)[1] = Math.max(R, m.get(m.size() - 1)[1]);
            }
        }
        return m.toArray(new int[m.size()][]);
    }
}
