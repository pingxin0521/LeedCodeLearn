package test01;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-2-29
 **/
public class PalindromeString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        boolean is = true;
        if (null != line && line.length() > 1) {
            char[] charArray = line.toCharArray();
            int len = charArray.length;
            int s = (int) len / 2;
            int i = s-1;
            int j = s;
            if (len % 2 != 0) {
                ++j;
            }
            while (i >= 0 && j < len) {
                if (charArray[i] != charArray[j]) {
                    is = false;
                    break;
                }
                --i;
                ++j;
            }
        }
        System.out.println(is?"True":"False");
    }
}
