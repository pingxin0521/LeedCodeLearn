package leetcode.week06.day02;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day02
 * hyp create at 20-7-26 下午3:11
 **/
public class MinNumberOperations {
    public int minNumberOperations(int[] t) {
        if (t == null || t.length == 0) {
            return 0;
        }
        if (t.length == 1) {
            return t[0];
        }
        int res = 0;
        int max = t[0];
        int len = t.length;
        for (int i = 1; i < len; i++) {
            if (t[i - 1] > t[i]) {
                res += max - t[i];
                max = t[i];
            }
            if (max < t[i]) {
                max = t[i];
            }

        }
        res += t[len - 1];
        return res;
    }
}
