package leetcode.week01.day05;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day05
 * hyp create at 20-3-16
 **/
public class HammingWeight {
    public int hammingWeight(int n) {
        int c = 0;
        //取完所有位数
        while (n != 0) {
            //n&1取左边最后一位,0或者1
            c += n & 1;
            //n左移一位
            //>>是有符号右移，>>>是无符号右移
            n >>>= 1;
        }
        return c;
    }
}
