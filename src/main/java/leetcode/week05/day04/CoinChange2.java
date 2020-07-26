package leetcode.week05.day04;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day04
 * hyp create at 20-6-29
 **/
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
}
