package leetcode.week05.day03;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class IsSubsequence {
    /**
     * 从s中依次取出一个字符，到t中去查找，记录出现的位置；
     * s中取出下一个字符，从上次出现位置的下一个开始查找，
     * 直到s中的字符全部扫描完成。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return true;
        int sLen = s.length();
        int index = 0, loc = 0;
        for (int i = 0; i < sLen; i++) {
            loc = t.indexOf(s.charAt(i), index);
            if (loc < 0) return false;
            index = loc + 1;
        }
        return true;
    }
}
