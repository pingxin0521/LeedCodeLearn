package leetcode.week05.day01;

/**
 * https://leetcode-cn.com/problems/binary-search/
 *
 * 初始条件：left = 0, right = length-1
 * 终止：left > right
 * 向左查找：right = mid-1
 * 向右查找：left = mid+1
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
