package leetcode.week04.day06;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day06
 * hyp create at 20-6-25
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }
}
