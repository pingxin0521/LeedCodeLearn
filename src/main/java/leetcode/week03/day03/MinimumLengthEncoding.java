package leetcode.week03.day03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day03
 * hyp create at 20-3-28
 **/
public class MinimumLengthEncoding {
    //https://leetcode-cn.com/problems/short-encoding-of-words/solution/wu-xu-zi-dian-shu-qing-qing-yi-fan-zhuan-jie-guo-j/
    public int minimumLengthEncoding(String[] words) {
        int N = words.length;
        Comparator<String> cmp = (s1, s2) -> {
            int N1 = s1.length();
            int N2 = s2.length();
            int min = Math.min(N1, N2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(N1 - i - 1);
                char c2 = s2.charAt(N2 - i - 1);
                int c = Character.compare(c1, c2);
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(N1, N2);
        };
        // 逆序字典序排序
        Arrays.sort(words, cmp);
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (i + 1 < N && words[i + 1].endsWith(words[i])) {
// 当前单词是下一个单词的后缀，丢弃
            } else {
                res += words[i].length() + 1; // 单词加上一个 '#' 的长度
            }
        }
        return res;
    }
}
