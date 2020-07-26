package leetcode.week01.day05;

/**
 * https://leetcode-cn.com/problems/house-robber
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day05
 * hyp create at 20-3-16
 **/
public class Rob {
    //求最大和
    //限制：取和的下标不相连
    //状态变换:dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            int t = Math.max(dp[1], dp[0] + nums[i - 1]);
            dp[0]=dp[1];
            dp[1]=t;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1, 2, 3, 1}));
    }
}
