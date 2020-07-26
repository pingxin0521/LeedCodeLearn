package leetcode.week01.day06;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day06
 * hyp create at 20-3-17
 **/
public class TitleToNumber {
    public int titleToNumber(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int res = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            int n = c - 'A' + 1;
            res = res * 26 + n;
        }
        return res;

    }

}
