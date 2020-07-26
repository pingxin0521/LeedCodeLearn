package leetcode.week02.day05;

import java.util.*;

/**
 * 字符串全排列
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sm
 * hyp create at 20-3-23
 **/
public class FullSortingOfStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        ArrayList<String> list = perms(line);
        TreeSet<String> lhs = new TreeSet<String>(list);
        System.out.println(lhs);
    }

    public static ArrayList<String> perms(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            res.add("");
            return res;
        }
        char c = s.charAt(0);
        String reminder = s.substring(1);
        ArrayList<String> words = perms(reminder);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String newStr = insertChatAt(word, c, i);
                res.add(newStr);
            }
        }
        return res;

    }

    public static String insertChatAt(String s, char c, int i) {
        String start = s.substring(0, i);
        String end = s.substring(i);
        return start + c + end;
    }


}
