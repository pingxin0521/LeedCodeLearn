package leetcode.week05.day04;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day04
 * hyp create at 20-6-29
 **/
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }

}
