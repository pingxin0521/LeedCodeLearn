package leetcode.week05.day01;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || "".equals(s)) {
            return true;
        }
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!map.containsKey(c1)) {
                if (map.containsValue(c2)) {
                    return false;
                } else {
                    map.put(c1, c2);
                }
            } else {
                if (!map.get(c1).equals(c2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
