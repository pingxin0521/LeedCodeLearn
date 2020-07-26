package test01;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * 删除重复字符串
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-3
 **/
public class RemoveDuplicateStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        char[] chars = line.toCharArray();

        //去重
        LinkedHashSet<Character> ll = new LinkedHashSet<>();
        for (char c : chars) {

            if (ll.contains(Character.toUpperCase(c)) ||
                    ll.contains(Character.toLowerCase(c))) {
                continue;
            }
            ll.add(c);
        }
        StringBuilder sb=new StringBuilder();
        for (Character c : ll) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
