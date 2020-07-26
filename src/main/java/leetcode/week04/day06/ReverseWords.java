package leetcode.week04.day06;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day06
 * hyp create at 20-6-25
 **/
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : ss) {
            int len = w.length();
            for (int i = len-1; i >= 0; i--) {
                sb.append(w.charAt(i));
            }
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));
    }
}
