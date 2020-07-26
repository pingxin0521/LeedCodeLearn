package test01;

import java.util.Scanner;

/**
 * 1 1
 * 2 1
 * 3 1
 * 4 1
 * 5 2
 * 6 3
 * 7 4
 * 8 5
 * 9 7
 * 10 10
 * ...
 * n f(n)=f(n-4)+f(n-1)
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-2-28
 **/
public class RabbitBreed {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num = 12;
        int count=1;
        if (num>=5)
        {
            int [] record=new int[num];
            for (int i = 0; i < 4; i++) {
                record[i]=1;
            }
            int i=4;
            while (i<num)
            {
                record[i]=record[i-1]+record[i-4];
                i++;
            }
            count=record[num-1];
        }

        System.out.println(count);
    }
}
