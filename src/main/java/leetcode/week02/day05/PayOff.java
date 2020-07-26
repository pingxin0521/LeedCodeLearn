package leetcode.week02.day05;

import java.util.Scanner;

/**
 * 发工资
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day05
 * hyp create at 20-3-23
 **/
public class PayOff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[]{100, 20, 10, 5, 1};
        int c = 0;
        int i = 0;
        while (n != 0) {
            if (n<data[i])
            {
                i++;
                continue;
            }else {
                int t = n / data[i];
                c+=t;
                n=n%data[i];
            }
        }
        System.out.println(c);
    }
}
