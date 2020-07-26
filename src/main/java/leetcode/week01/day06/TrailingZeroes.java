package leetcode.week01.day06;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day06
 * hyp create at 20-3-17
 **/
public class TrailingZeroes {
    //10
    //2*5
    //11!=11*(2*5)*9*(2*2*2)*7*(3*2)*5*(2*2)*3*2*1
    //除了每隔 5 个数算作一个 5，每隔 25 个数，还需要多算一个 5。
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
