package leetcode.week01.day02;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/deep-dark-fraction/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class Fraction {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 0, 2};
        System.out.println(Arrays.toString(fraction(arr)));
    }

    public static int[] fraction(int[] cont) {
        int[] ans = new int[]{1, 1};
        int len = cont.length;
        if (len == 0) {
            return ans;
        }
        ans[1] = cont[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            int t = ans[1];
            ans[1] = cont[i] * ans[1] + ans[0];
            ans[0] = t;
        }
        int t = ans[0];
        ans[0] = ans[1];
        ans[1] = t;

        return ans;
    }
}
