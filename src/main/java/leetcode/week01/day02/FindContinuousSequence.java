package leetcode.week01.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class FindContinuousSequence {
    //https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/java-shuang-100-by-vapormax/
    public static int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 1;
        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] arr = new int[i];
                for (int k = target / i, j = 0; k < target / i + i; k++, j++) {
                    arr[j] = k;
                }
                res.add(arr);
            }
        }
        Collections.reverse(res);
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(15)));

    }
}
