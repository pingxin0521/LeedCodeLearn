package leetcode.week05.day04;

/**
 * https://leetcode-cn.com/problems/dungeon-game/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day04
 * hyp create at 20-6-29
 **/
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int dpmin = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, dpmin - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
