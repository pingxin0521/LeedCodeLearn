package leetcode.week06.day03;

/**
 * https://leetcode-cn.com/problems/shuffle-string/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day03
 * hyp create at 20-7-26 下午3:13
 **/
public class RestoreString {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            res[indices[i]] = chars[i];
        }
        return new String(res);
    }
}
