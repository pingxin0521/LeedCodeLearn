package test07;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class ReverseInteger {
    public int reverse(int x) {
        int max = 0x7fffffff, min = 0x80000000;//int的最大值最小值
        long rs = 0;//用long类型判断溢出
        for (; x >= 0; rs = rs * 10 + x % 10, x /= 10) {
            ;//逆序，正负通吃，不用单独考虑负值
        }
        return (rs > max || rs < min) ? 0 : (int) rs;//超了最大值低于最小值就返回0
    }

    public int reverse2(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
