package leetcode.week01.day01;

/**
 * 买股票的最佳时机
 *
 * TODO 需要理解
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01
 * hyp create at 20-3-12
 **/
public class MaxProfit {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * 遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


    //    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i][j] ，表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票

        int[] dp = new int[5];
        dp[1] = -prices[0];
        // 3 状态都还没有发生，因此应该赋值为一个不可能的数
        dp[3] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[0] = 0;
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return Math.max(0, Math.max(dp[2], dp[4]));
    }

    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-4-8/
    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //K 看做任意次，转到 122 题
        if (k >= prices.length / 2) {
            return maxProfit2(prices);
        }
        int K = k;
        int[] dp = new int[K + 1];
        int min[] = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            min[i] = prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int kk = 1; kk <= K; kk++) {
                min[kk] = Math.min(prices[i] - dp[kk - 1], min[kk]);
                dp[kk] = Math.max(dp[kk], prices[i] - min[kk]);
            }
        }
        return dp[K];
    }

    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
    public int maxProfit5(int[] prices) {
        int len = prices.length;
        // 特判
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[3];

        // 初始化
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0;

        int preCash = dp[0];
        int preStock = dp[1];

        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(preCash, preStock + prices[i]);
            dp[1] = Math.max(preStock, dp[2] - prices[i]);
            dp[2] = preCash;

            preCash = dp[0];
            preStock = dp[1];
        }
        return Math.max(dp[0], dp[2]);
    }
}
