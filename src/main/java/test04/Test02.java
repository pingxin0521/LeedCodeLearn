package test04;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 * <p>
 * 输入的字符串长度不会超过1000。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test04
 * hyp create at 19-8-16
 **/
public class Test02 {

    int num = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);//回文串长度为奇数
            count(s, i, i + 1);//回文串长度为偶数
        }
        return num;
    }

    public void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }
}
