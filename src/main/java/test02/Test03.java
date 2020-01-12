package test02;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test02
 * hyp create at 19-10-17
 **/
public class Test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = 0;
        int num = 0;
        if (in.hasNextInt()) {
            len = in.nextInt();
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        num = in.nextInt();
        operate(len, arr, num);

    }

    public static void operate(int len, int[] arr, int num) {
        if (len == 0 || arr.length == 0) {
            System.out.println("-1 -1");
            return;
        }
        int f=-1;
        int t=-1;

        for (int i = 0; i < arr.length && num >= arr[i]; i++) {
            if(arr[i]==num)
            {
                if (f==-1)
                {
                    f=i;
                }
                t=i;
            }

        }
        System.out.println(f+" "+t);
    }

}
