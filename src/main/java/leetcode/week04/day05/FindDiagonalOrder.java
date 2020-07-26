package leetcode.week04.day05;

/**
 * https://leetcode-cn.com/problems/diagonal-traverse/
 * <p>
 * <p>
 * 我们现在将每一条对角线作出从0 开始的编号，可以发现最后一个的编号是 M + N - 1；并且如果编号为奇数自上而下遍历，偶数则是自下而上遍历
 * <p>
 * 关注每一条对角线上的坐标和：对于每一条对角线上的坐标(m,n)，m + n = 编号 是我们发现的规律
 * <p>
 * 最后一步就是确定边界：
 * <p>
 * 多少次遍历：矩阵有多少个元素就遍历多少次
 * 到什么时候结束：对于最长对角线以上来说，到 m 或者 n 中的某一个到 0 为止；对于最长对角线下面来说，到 m 或者 n 中的某一个到达边界为止。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int size = matrix.length * matrix[0].length;
        int index = 0;
        int[] result = new int[size];
        int maxK = matrix.length + matrix[0].length;

        for (int k = 0; k < maxK; k++) {
            int m = 0, n = 0;

            if (k % 2 == 0) //偶数部分
            {
                if (k < matrix.length) {
                    m = k;
                    n = 0;
                } else {
                    m = matrix.length - 1;
                    n = k - m;
                }
                while (m >= 0 && n < matrix[0].length) //n到达边界为止
                {
                    result[index++] = matrix[m][n];
                    m--;
                    n++;
                }
            } else //奇数部分
            {
                if (k < matrix[0].length) {
                    m = 0;
                    n = k;
                } else {
                    n = matrix[0].length - 1;
                    m = k - n;
                }
                while (m < matrix.length && n >= 0) //m到达边界为止
                {
                    result[index++] = matrix[m][n];
                    m++;
                    n--;
                }
            }
        }

        return result;
    }
}
