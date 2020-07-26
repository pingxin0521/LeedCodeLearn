package leetcode.week05.day01;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class SearchRotationSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
     * <p>
     * 如果我们在找mid的过程中，如果我们得到start，mid，end都相同，那么我们要对start和end进行操作，start+1, end-1，去试图skip掉那些重复的数字。
     * <p>
     * 接下来，我们就正常按照start是否大于mid来进行逻辑判断，缩减范围寻找目标数。start大于mid，证明mid+1 到 end是上升区间；反之则证明start 到 mid是上升区间。
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if ((nums[mid] == nums[start]) && (nums[mid] == nums[end])) {
                start++;
                end--;
            } else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
