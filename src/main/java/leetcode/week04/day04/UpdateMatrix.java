package leetcode.week04.day04;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day04
 * hyp create at 20-6-22
 **/
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        //初始化,可以为任意不代表位置的值
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 10001);
        }
        //初始化0的距离为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) dp[i][j] = 0;
            }
        }

        //状态转移
        //第一次填表从左上到右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        //第二次填表从右下到左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        UpdateMatrix matrix = new UpdateMatrix();
        System.out.println(Arrays.deepToString(matrix.updateMatrix(new int[][]{{0, 0, 0, 0}, {0, 1, 1, 1}, {1, 1, 1, 1}})));
    }
}
