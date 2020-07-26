package leetcode.week03.day05;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day05
 * hyp create at 20-4-3
 **/
public class BracketsPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        char[][] keys = new char[][]{{'{', '}'}, {'(', ')'}, {'[', ']'}};

        int[] tmp = new int[3];

        int len = line.length();

        boolean ok = true;
        for (int i = 0; i < len; i++) {
            char c = line.charAt(i);
            if (c == keys[0][0]) {
                tmp[0]++;
                continue;
            }
            if (c == keys[1][0]) {
                tmp[1]++;
                continue;
            }
            if (c == keys[2][0]) {
                tmp[2]++;
                continue;
            }

            if (c == keys[0][1]) {
                tmp[0]--;
                if (tmp[0] < 0) {
                    ok = false;
                    break;
                }
            }
            if (c == keys[1][1]) {
                tmp[1]--;
                if (tmp[1] < 0) {
                    ok = false;
                    break;
                }
            }
            if (c == keys[2][1]) {
                tmp[2]--;
                if (tmp[2] < 0) {
                    ok = false;
                    break;
                }
            }
        }
        if (ok && (tmp[0] > 0 || tmp[1] > 0 || tmp[2] > 0)) {
            ok = false;
        }

        System.out.println(ok ? "true" : "false");

    }
}
