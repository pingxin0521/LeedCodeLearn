package leetcode.week01.day04;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares n = new NumSquares();
        System.out.println(n.numSquares(13));
    }
}
