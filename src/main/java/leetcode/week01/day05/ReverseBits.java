package leetcode.week01.day05;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day05
 * hyp create at 20-3-16
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        //整数总位数32
        //前面补零
        //n&1左边最后一位
        //bs记录右移位置
        for (int bs = 31; n != 0; n = n >>> 1, bs--) {
            ans += (n & 1) << bs;
        }
        return ans;
    }
}
