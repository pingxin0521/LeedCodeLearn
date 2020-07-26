package leetcode.week01.day07;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day07
 * hyp create at 20-3-18
 **/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
