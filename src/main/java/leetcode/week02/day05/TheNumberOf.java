package leetcode.week02.day05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 神策数对
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day05
 * hyp create at 20-3-23
 **/
public class TheNumberOf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        in.nextLine();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.nextLine();


        int m = in.nextInt();
        int[] b = new int[m];

        in.nextLine();

        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int c = 0;

        int t = 0;

        for (int i = 0; i < b.length; i++) {
            int j = 0;
            while (b[i] >= a[t]) {
                t++;
                j++;
                if (t >= a.length) {
                    break;
                }

            }
            if (j>0)
            {
                if (j>1) {
                    t=t+j-1;
                }
                c++;
            }

        }

        System.out.println(c);

    }
}
