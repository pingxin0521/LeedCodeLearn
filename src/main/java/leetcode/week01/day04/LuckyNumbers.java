package leetcode.week01.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class LuckyNumbers {
    public static void main(String[] args) {
        int[][] arr = {{1,10,4,2}, {9,3,8,7}, {15,16,17,12}};

        System.out.println(new LuckyNumbers().luckyNumbers(arr));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] hArr = new int[m];
        for (int i = 0; i < m; i++) {
            int r = matrix[i][0];
            int k = i;
            int l = 0;
            for (int j = 1; j < n; j++) {
                if (r > matrix[i][j]) {
                    r = matrix[i][j];
                    l = j;
                }
            }
            hArr[i] = l;
        }
        for (int i = 0; i < hArr.length; i++) {
            int j = hArr[i];
            int d = matrix[i][j];
            int k = 0;
            for (; k < m; k++) {
                if (matrix[k][j] > d) {
                    break;
                }
            }
            if (k >= m) {
                res.add(d);
            }
        }
        return res;
    }
}
