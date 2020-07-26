package leetcode.week04.day05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        List<String> list = Arrays.stream(s.trim().split(" "))
                .filter((ts) -> !"".equals(ts))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        if (list.size() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("a good   example"));
        System.out.println(new ReverseWords().reverseWords(" "));

    }
}
