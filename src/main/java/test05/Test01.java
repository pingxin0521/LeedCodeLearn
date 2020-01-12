package test05;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test05
 * hyp create at 19-10-22
 **/
public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = 0;
        if (in.hasNextInt()) {
            nums = in.nextInt();
            in.nextLine();
        }
        for (int i = 0; i < nums; i++) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            check(s1, s2);
        }
    }

    private static void check(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return;
        }
        boolean is = false;
        if (s1.length() >= s2.length()) {
            char[] cs1 = s1.toCharArray();
            char[] cs2 = s2.toCharArray();
            int len1 = cs1.length;
            int len2 = cs2.length;
            int len = (len1 > len2 ? len1 : len2);
            int i = 0, j = 0;
            while (i < len1 && j < len2) {
                if (cs1[i] == cs2[j]||Character.toUpperCase(cs1[i])==cs2[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (i == len1 && j == len2) {
                is = true;
            }
        }

        if (is) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
