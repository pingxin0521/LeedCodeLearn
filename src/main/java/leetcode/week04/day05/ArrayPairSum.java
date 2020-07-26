package leetcode.week04.day05;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class ArrayPairSum {
    //使得配对中最小的总和最大,即a-b最大，
    //我们可以对给定数组的元素进行排序，并直接按排序顺序形成元素的配对
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
