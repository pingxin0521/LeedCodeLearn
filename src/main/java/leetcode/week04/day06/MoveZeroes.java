package leetcode.week04.day06;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 定义一个非零的指针 j=0，循环遍历数组用指针j记录非零值nums[j] = num[i];
 * 判断两个指针i与j是否相等，这里两个指针初始值都为0，j指针只有在非零的情况下会j++；
 * 因此可以判断j指针对应的值都为非零的数据，且保存原有顺序；
 * 所以，原有数组继续遍历情况下，nums[i]都为0。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day06
 * hyp create at 20-6-25
 **/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
