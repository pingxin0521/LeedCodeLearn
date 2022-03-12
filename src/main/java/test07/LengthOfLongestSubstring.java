package test07;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }

        int len=s.length();
        Map<Character,Integer> map = new HashMap<>();

        int l=0;
        int max = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            l = Math.max(l,map.getOrDefault(c,-1)+1);
            max = Math.max(max,i-l+1);
            map.put(c,i);
        }

        return max;
    }
}
