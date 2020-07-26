package leetcode.week05.day02;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day02
 * hyp create at 20-6-26
 **/
public class SearchRange {
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int l=0;
        int h=nums.length;
        while (l<h){
            int m=(l+h)/2;
            if (nums[m]>target||(left&&target==nums[m])){
                h=m;
            }else {
                l=m+1;
            }
        }
        return l;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        if (nums == null || nums.length == 0) {
            return targetRange;
        }
        int leftIdx = extremeInsertionIndex(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }
        targetRange[0]=leftIdx;
        targetRange[1]=extremeInsertionIndex(nums,target,false)-1;
        return targetRange;
    }
}
