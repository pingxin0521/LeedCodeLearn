package test01;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-21
 **/
public class Test09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int res = 0;

        res += n > m ? n / 2 : m / 2;
        boolean t = false;
        if (m % 2 != 0) {
            res += n / 2;
            if (n % 2 != 0) {
                t = true;
                res++;
            }
        }
        if (n % 2 != 0) {
            res += m / 2;
            if (!t) {
                res++;
            }
        }

        System.out.println(res);
    }
}
