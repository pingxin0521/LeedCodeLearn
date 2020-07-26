package leetcode.week05.day07;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * 满足条件的子序列数目
 * <p>
 * 该题目只需要子数组的最小值+最大值<=target，因此，如果有个滑动窗口，滑动窗口内的最小值+最大值小于等于target的话，那么这个子数组进行排列组合，在包含最小值的情况下，排列组合的结果都符合题意。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day07
 * hyp create at 20-7-1
 **/
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] * 2 > target) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        int mode = 1_0000_0000_7;
        for (int i = 1; i < nums.length; i ++) {
            pow[i] = pow[i-1] * 2;
            pow[i] %= mode;
        }
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res += pow[right - left];
                res %= mode;
                left ++;
            }
            else {
                right --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfyTheGivenSumCondition condition = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
        int i = condition.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12);
        System.out.println(i);
    }
}
