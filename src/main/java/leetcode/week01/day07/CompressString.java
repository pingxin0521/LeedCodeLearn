package leetcode.week01.day07;

/**
 * https://leetcode-cn.com/problems/compress-string-lcci/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day07
 * hyp create at 20-3-18
 **/
public class CompressString {
    public String compressString(String s) {
        if (null == s || "".equals(s)) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        int count = 0;
        while (i < n) {
            char c = s.charAt(i++);
            count++;
            while (i<n&&c == s.charAt(i)) {
                count++;
                i++;
            }
            sb.append(c).append(count);
            count = 0;
        }
        if (n <= sb.length()) {
            return s;
        } else {
            return sb.toString();
        }
    }
}
