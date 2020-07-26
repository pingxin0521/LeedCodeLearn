package leetcode.week01.day05;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day05
 * hyp create at 20-3-16
 **/
public class Rotate {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
