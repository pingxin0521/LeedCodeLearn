package leetcode.week01.day04;

/**
 * https://leetcode-cn.com/problems/add-digits
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class AddDigits {
    //https://leetcode-cn.com/problems/add-digits/solution/java-o1jie-fa-de-ge-ren-li-jie-by-liveforexperienc/
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
