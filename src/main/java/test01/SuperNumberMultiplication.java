package test01;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-4
 **/
public class SuperNumberMultiplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();

        String s = String.valueOf(a);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }

        BigInteger bia = new BigInteger(sb.toString());
        BigInteger bib = new BigInteger(String.valueOf(b));


        char[] array = bia.multiply(bib).toString().toCharArray();
        int res = 0;
        for (char c : array) {
            res = res + Character.getNumericValue(c);
        }

        System.out.println(res);

    }
}
