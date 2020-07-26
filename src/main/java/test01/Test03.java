package test01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-2-29
 **/
public class Test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String sub = line.substring(1, line.length() - 1);

        String[] strings = sub.split(",");

        int [] arr=new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            arr[i]=Integer.parseInt(strings[i].trim());
        }
        int [] res=new int[arr.length];


        for (int i = 0; i < arr.length-1; i++) {
            int tmp=arr[i];
            int count=0;
            for (int j=i+1;j<arr.length;j++)
            {
                if (arr[j]<tmp)
                {
                    ++count;
                }
            }
            res[i]=count;
        }
        res[arr.length-1]=0;
        System.out.println(Arrays.toString(res));
    }
}
