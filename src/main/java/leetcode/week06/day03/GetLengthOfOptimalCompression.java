package leetcode.week06.day03;

/**
 * https://leetcode-cn.com/problems/string-compression-ii/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day03
 * hyp create at 20-7-26 下午3:19
 **/
public class GetLengthOfOptimalCompression {
    public int getLengthOfOptimalCompression(String s, int k) {
        // dp[pos][k][c][size] represent solution when handling first pos character,
        // deleting k character, where last deleted character is c
        // and the number of char c being deleted is size
        return dfs(s, 0, k, 'a', 0, new Integer[s.length() + 1][k + 1][26][101]);
    }

    private int dfs(String s, int pos, int k, char c, int size, Integer[][][][] dp) {
        if (pos == s.length()) return 0;
        if (dp[pos][k][c - 'a'][size] != null) return dp[pos][k][c - 'a'][size];

        int ans = 101;
        // if delete
        if (k > 0) {
            ans = Math.min(ans, dfs(s, pos + 1, k - 1, c, size, dp));
        }

        // if not delete
        if (s.charAt(pos) == c) {
            // special case
            if (size == 0 || size == 1 || size == 9 || size == 99) {
                ans = Math.min(ans, dfs(s, pos + 1, k, c, size + 1, dp) + 1);
            } else {
                ans = Math.min(ans, dfs(s, pos + 1, k, c, size + 1, dp));
            }
        } else {
            ans = Math.min(ans, dfs(s, pos + 1, k, s.charAt(pos), 1, dp) + 1);
        }
        return dp[pos][k][c - 'a'][size] = ans;
    }
}
