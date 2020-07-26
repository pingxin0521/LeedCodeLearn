package leetcode.week05.day04;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day04
 * hyp create at 20-6-28
 **/
public class Rob2 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(myRob(nums, 0, len - 1), myRob(nums, 1, len));
    }

    public int myRob(int[] nums, int lo, int h) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[lo];
        for (int i = lo+2; i <= h; i++) {
            int t = Math.max(dp[1], dp[0] + nums[i - 1]);
            dp[0] = dp[1];
            dp[1] = t;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        Rob2 rob2 = new Rob2();
        System.out.println(rob2.rob(new int[]{2, 3, 2}));
        System.out.println(rob2.rob(new int[]{1,2, 3, 1}));

    }
}
