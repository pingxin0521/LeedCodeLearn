package leetcode.week04.day05;

/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/783/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class ReverseString {
    public void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }
        int i = 0, j = s.length - 1;
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;

            i++;
            j--;
        }
    }
}
