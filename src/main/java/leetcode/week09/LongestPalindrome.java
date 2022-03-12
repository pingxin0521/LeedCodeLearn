package leetcode.week09;

import java.util.Map;
import java.util.stream.Collectors;

public class LongestPalindrome {
    /**
     * https://leetcode-cn.com/problems/longest-palindrome/
     *回文串里每种字符都出现了偶数次，除了奇数长度的回文串的时候最中间的那个字符可以出现奇数次
     * @param s
     * @return
     */
    public int longestPalindrome1(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x : cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }

    public int longestPalindrome2(String s) {
        Map<Integer, Integer> count = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return ans < s.length() ? ans + 1 : ans;
    }

}
