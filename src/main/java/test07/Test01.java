package test07;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 19-11-21
 **/
public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }

        int num = 0;
        int[] out = new int[len];
        for (int i = 0; i < arr.length; i++) {
            int p = -1;
            boolean has = false;
            for (int j = 0; j < num; j++) {
                if (arr[i] == out[j]) {
                    has = true;
                    break;
                }
                if (arr[i] < out[j]) {
                    p = j;
                    break;
                }
            }
            if (has) {
                continue;
            }
            if (p == -1) {
                out[0] = arr[0];
                num++;
            } else {
                if (p == num - 1) {
                    out[num] = arr[i];
                } else {
                    for (int j = num; j > p; j--) {
                        out[j] = out[j - 1];
                    }
                    out[p] = arr[i];
                }
                num++;
            }

        }
        for (int i = 0; i < num; i++) {
            System.out.println(out[i]);
            if (i != num - 1) {
                System.out.println(" ");
            }
        }

    }
}

//6
//6 5 1 6 9 1