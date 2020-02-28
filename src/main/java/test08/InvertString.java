package test08;

import java.util.Scanner;

/**
 * 字符串倒置
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-25
 **/
public class InvertString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strings = line.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
