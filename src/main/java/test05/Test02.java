package test05;

import java.util.*;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test05
 * hyp create at 19-10-22
 **/
public class Test02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0, j = 0;
        i = in.nextInt();
        j = in.nextInt();
        int key = in.nextInt();
        int ch = in.nextInt();
        int inc = in.nextInt();

        int[][] arrs = new int[i][j];
        for (int t = 0; t < i; t++) {
            for (int n = 0; n < j; n++) {
                arrs[t][n] = in.nextInt();
            }
            in.nextLine();
        }
        List<Integer> keyArr=new ArrayList<Integer>();
        List<Integer> lineArr=new ArrayList<Integer>();
        List<List<Integer>> conArrs=new ArrayList<List<Integer>>();

        for (int[] arr : arrs) {
            int index = keyArr.indexOf(arr[key]);
            if (index>=0)
            {
                int lindex = lineArr.indexOf(arr[ch]);
                if(lindex>=0)
                {

                }else {

                }
            }else {
                keyArr.add(arr[key]);
            }
        }

    }

}
