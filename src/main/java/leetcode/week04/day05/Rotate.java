package leetcode.week04.day05;

/**
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class Rotate {
    //先以左上到右下对角线为轴进行翻转，再以每一行中点进行翻转
    /*
        1,2,3
        4,5,6
        7,8,9
        ----
        1,4,7
        2,5,8
        3,6,9
        -----
        7,4,1
        8,5,2
        9,6,3
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
