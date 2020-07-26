package leetcode.week05.day01;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class FirstUniqueCharacterUnAString {
    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        int[] tmp = new int[26];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 0;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int t = (s.charAt(i) - 'a');
            tmp[t]++;
        }
        for (int i = 0; i < n; i++) {
            int t = (s.charAt(i) - 'a');
            if (tmp[t] == 1) {
                return i;
            }
        }
        return -1;
    }
}
