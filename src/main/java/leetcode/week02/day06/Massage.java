package leetcode.week02.day06;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day06
 * hyp create at 20-3-24
 **/
public class Massage {
    public int massage(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
