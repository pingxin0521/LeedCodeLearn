package leetcode.week04.day05;

/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/788/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }

        return max > count ? max : count;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes ones = new FindMaxConsecutiveOnes();
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
