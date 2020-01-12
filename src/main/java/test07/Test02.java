package test07;

import java.util.Scanner;

/**
 * 最小非重复子串
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-6
 **/
public class Test02 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int max_length_substring(String s) {
        int max = 1;
        boolean flag = false;
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        flag = true;
                        break;
                    } else if (k == j - 1 && j - i + 1 > max) {
                        max = j - i + 1;
                    }
                }
                if (flag) {
                    if (j - i > max) {
                        max = j - i;
                    }
                    flag = false;
                    break;
                }
            }
            //如果最大长度大于剩余长度
            if (s.length() - i - 1 < max) {
                break;
            }
        }
        return max;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = max_length_substring(_s);
        System.out.println(String.valueOf(res));

    }
}
