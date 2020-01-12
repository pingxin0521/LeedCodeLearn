package test02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test02
 * hyp create at 19-10-17
 **/
public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = 0;
        int sum = 0;
        if (in.hasNextInt()) {
            len = in.nextInt();
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        sum = in.nextInt();
        System.out.println(len + "," + Arrays.toString(arr) + "," + sum);
        operate(len, arr, sum);

    }

    public static void operate(int len, int[] arr, int sum) {
        if (len == 0 || arr.length == 0) {
            System.out.println("-1 -1");
            return;
        }

        for (int i = 0; i < arr.length ; i++) {
            int ot = sum - arr[i];
            int j = 0;
            while (j < len) {

                if (ot == arr[j] && i != j) {
                    System.out.println(i + " " + j);
                    return;
                }
                j++;
            }

        }
        System.out.println("-1 -1");
    }


}
