package test01;

import java.util.Scanner;

/**
 * 统计字符串
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-3
 **/
public class StatisticalString {

    private static final int Mod = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long res=n^2%Mod;
        res=res*res%Mod;



    }

}
