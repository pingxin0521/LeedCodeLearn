package leetcode.week02.day03;

/**
 * https://leetcode-cn.com/problems/pizza-with-3n-slices/solution/hua-jian-wei-qu-n3ge-bu-xiang-lin-shu-zi-de-zui-da/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day03
 * hyp create at 20-3-22
 **/
public class MaxSizeSlices {
    public int maxSizeSlices(int[] slices) {
        int[] dp = new int[slices.length];
        int tmp = slices[0];
        slices[0] = 0;
        int v1 = getV(slices, dp);
        slices[0] = tmp;
        slices[slices.length - 1] = 0;
        int v2 = getV(slices, dp);
        return Math.max(v1, v2);
    }

    public int getV(int[] slices, int[] dp) {
        int curMax = 0;
        int len = slices.length;
        for (int i = 0; i < len; i++) {
            curMax = Math.max(curMax, slices[i]);
            dp[i] = slices[i];
        }
        for (int i = 1; i < len / 3; i++) {
            int pre = dp[0];
            int a = dp[0];
            int b = dp[1];
            for (int j = 0; j < dp.length; j++) {
                if (j <= 1) dp[j] = slices[j];
                else {
                    pre = Math.max(pre, a);
                    int tmp = dp[j];
                    dp[j] = pre + slices[j];
                    a = b;
                    b = tmp;
                }
                curMax = Math.max(dp[j], curMax);
            }
        }
        return curMax;
    }

}
