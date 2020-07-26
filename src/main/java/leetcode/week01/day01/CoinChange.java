package leetcode.week01.day01;

import java.io.Serializable;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day01
 * hyp create at 20-3-12
 **/
public class CoinChange implements Serializable {
    /**
     * 对于这道题，以coins = [1, 2, 5], amount = 11为例
     *
     * ```
     * dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1)
     * ```
     *
     * 我们要求组成11的最少硬币数，可以考虑组合中的最后一个硬币分别是1，2，5的情况，比如
     *
     * - 最后一个硬币是1的话，最少硬币数应该为【组成10的最少硬币数】+ 1枚（1块硬币）
     * - 最后一个硬币是2的话，最少硬币数应该为【组成9的最少硬币数】+ 1枚（2块硬币）
     * - 最后一个硬币是5的话，最少硬币数应该为【组成6的最少硬币数】+ 1枚（5块硬币）
     *
     * 在这3种情况中硬币数最少的那个就是结果
     *
     * 按同样的道理，我们也可以分别再求出组成10的最少硬币数，组成9的最少硬币数，组成6的最少硬币数。。。
     *
     * 发现了吗，这种当前状态的问题可以转化成之前状态问题的，一般就是动态规划的套路
     *
     * 所以我们自底向上依次求组成1，2...一直到11的最少硬币数
     *
     * 对每一个数，依次比较最后一个硬币是不同面额的情况，从中选出最小值
     *
     * ⚠️注意：这里有两个小技巧：
     *
     * - 预设一个0位方便后续计算，组成0的最少硬币数是0，所以`dp[0] = 0`
     * - 给每一个数预设一个最小值`amount+1`，因为硬币面额最小为整数1，所以只要有解，最小硬币数必然小于`amount+1`
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0; i<amount+1; i++) {
            dp[i] = i == 0 ? 0 : amount+1;
            for(int coin : coins) {
                if(i >= coin) {
                    dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];

    }
}
