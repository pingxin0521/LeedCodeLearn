package test08;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-28
 **/
public class PrintMatrix {

    /**
     * 分别设置上下左右四个墙壁，当一行或一列全部输出时，就把对应墙壁向内移动。
     * 设置flag，标志着现在该横向还是纵向移动。设置colFlag和rowFlag，分别代表着横向和纵向移动的方向(向左，向右，向下，向上)。
     * 当移动到转换横纵移动方向时，要把循环最后越界的数据下标，恢复到转换方向后正确的下标。
     * 每次循环后，判断墙壁是否重复，重复就证明矩阵中数字已经遍历完全。
     */

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        // 四个边界值
        int top = 0;
        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        // 横着和竖着相加的值（1/-1）
        int colFlage = 1;
        int rowFlage = 1;
        //  现在是否是横着移动
        boolean flag = true;
        int i = 0;
        int j = 0;

        while (bottom != top && right != left) {
            // 横向移动
            if (flag) {
                for (; j < right && j >= left; j += rowFlage) {
                    list.add(matrix[i][j]);
                }
                // 缩小墙壁
                if (rowFlage > 0) {
                    top++;
                } else {
                    bottom--;
                }
                // 指针恢复
                i += rowFlage;
                // 切换下次横向移动方向
                rowFlage = -rowFlage;
                j += rowFlage;
            }
            // 纵向移动
            if (!flag) {
                for (; i < bottom && i >= top; i += colFlage) {
                    list.add(matrix[i][j]);
                }
                // 缩小墙壁
                if (colFlage > 0) {
                    right--;
                } else {
                    left++;
                }
                // 切换下次纵向移动方向
                colFlage = -colFlage;
                // 恢复指针位置
                i += colFlage;
                j += colFlage;
            }
            // 切换横向和竖向移动
            flag = !flag;
        }

        return list;


    }

    public static void main(String[] args) {
        int[][] arr = new int[10][4];
        int val = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = val;
                val++;
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }


        ArrayList<Integer> list = printMatrix(arr);
        System.out.println(list.toString());
    }


}
