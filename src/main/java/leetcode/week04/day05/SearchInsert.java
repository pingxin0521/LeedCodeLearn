package leetcode.week04.day05;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class SearchInsert {
    //数组有序，则二分查找左边坐标即可
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= nums[0]) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        if (target > nums[right]) {
            return nums.length;
        }
        while (left < right) {
            int idx = (left + right) >> 1;
            if (nums[idx] < target) {
                left = idx + 1;
            } else {
                right = idx;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}
