package test05;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test05
 * hyp create at 19-10-30
 **/
public class Test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String line = in.nextLine();
        System.out.println(station("B-6B-5-5CD---F2.3"));
    }

    public static int station(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        int sum = 0;
        int pos = 1;
        int tmp = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '-') {
                if (tmp!=0)
                {
                    sum = sum + tmp * pos;
                    if (pos == -1) {
                        pos = 1;
                    }
                    tmp=0;
                }
                pos *= -1;
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                tmp = tmp * 10 + Character.getNumericValue(arr[i]);
            } else {
                sum = sum + tmp * pos;
                if (pos == -1) {
                    pos = 1;
                }
                tmp = 0;
            }
        }
        sum = sum + tmp * pos;
        return sum;

    }
}
