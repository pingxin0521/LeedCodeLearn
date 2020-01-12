package test04;

/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test04
 * hyp create at 19-8-16
 **/
public class Test03 {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseqOptimizeSpace(s);
    }

    /**
     * 思路：
     * 设dp[i][j]表示s[i:j]中的最长回文子序列长度，则
     * (1) s[i] == s[j] ==> dp[i][j] = dp[i+1][j-1] + 2;
     * (2) s[i] != s[j] ==> dp[i][j] = max(dp[i+1][j], dp[i][j-1])
     * 初始化: dp[i][i] = 1
     * return dp[0][n-1]
     */
    public int longestPalindromeSubseqOrdinary(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 优化空间为O(n)
     */

    public int longestPalindromeSubseqOptimizeSpace(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] pre = new int[n];
        int[] cur = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            cur[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    cur[j] = pre[j - 1] + 2;
                } else {
                    cur[j] = Math.max(pre[j], cur[j - 1]);
                }
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[n - 1];
    }
}
