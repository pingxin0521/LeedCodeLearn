package leetcode.week04.day05;

/**
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class PivotIndex {
    //求数组所有成员和，再从左到右求和
    public int pivotIndex(int[] nums) {
        int sum= 0;
        for (int num : nums) {
            sum+=num;
        }
        int lsum=0;
        for (int i = 0; i < nums.length; i++) {
            if ((sum-lsum-nums[i])==lsum){
                return i;
            }else {
                lsum+=nums[i];
            }
        }
        return -1;
    }
}
