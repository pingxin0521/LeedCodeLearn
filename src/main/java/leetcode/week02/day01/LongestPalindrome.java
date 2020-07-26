package leetcode.week02.day01;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day01
 * hyp create at 20-3-19
 **/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Integer, Integer> count = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return ans < s.length() ? ans + 1 : ans;
    }
}
