package leetcode.week05.day03;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class NonDecreasingArray {
    /**
     * 这里有个问题是出现非递减的数时，应该让后一个数等于前一个数，还是让前一个数等于后一个数。观察可以得到规律：
     *
     * 如果出现一个数数不仅小于前一个数，还小于前两个数，如【4，5，2】，则让后一个数等于前一个数
     *
     * 如果当前数仅小于前一个数，如【3，5，4】，则让前一个数等于后一个数。
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            if (i >= 2 && nums[i] < nums[i - 2]) {
                nums[i] = nums[i - 1];
                count++;
            } else {
                nums[i - 1] = nums[i];
                count++;
            }
        }
        return count <= 1;
    }
}
