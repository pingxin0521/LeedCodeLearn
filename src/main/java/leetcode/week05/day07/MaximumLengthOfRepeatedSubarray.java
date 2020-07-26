package leetcode.week05.day07;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day07
 * hyp create at 20-7-1
 **/
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[] dp = new int[B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = B.length; j >= 1; j--) {
                if (A[i - 1] == B[j - 1])
                    dp[j] = dp[j - 1] + 1;
                else
                    dp[j] = 0;
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
