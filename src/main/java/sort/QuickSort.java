package sort;

import java.util.Arrays;

/**
 * 快排
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-5
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 调用quickSort函数
     *
     * @param a 数组
     */
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 进行递归的快排
     *
     * @param a
     * @param lo
     * @param h
     */
    public static void quickSort(int[] a, int lo, int h) {
        if (h <= lo) {
            return;
        }
        // j为基准值的位置
        int j = partition(a, lo, h);
        // 进行递归调用，将j前面的进行快排
        quickSort(a, lo, j - 1);
        // 进行递归调用，将j后面的进行快排
        quickSort(a, j + 1, h);
    }

    /**
     * 进行切分，并进行交换
     *
     * @param a  数组
     * @param lo 切分开始的位置
     * @param h  切分结束的位置
     * @return 返回分界点的位置
     */
    public static int partition(int[] a, int lo, int h) {
        // 选取中间的值为基准值
        int middle = (lo + h + 1) / 2;
        int v = a[middle];
        // 将基准值和a[lo]交换位置
        exc(a, lo, middle);

        int i = lo;
        int j = h + 1;
        while (true) {

            // 假如左边的小于基准值，则一直进行循环
            while (a[++i] < v) {
                // 防止越界
                if (i == h) {
                    break;
                }
            }
            // 假如右边的大于基准值，则一直进行循环
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            // 一旦i>=j则代表i前面的除第一个外都比基准值小，j后面的都比基准值大，这时候就可以跳出循环了
            if (i >= j) {
                break;
            }

            // 进行交换(因为a[lo]>v,a[h]<v，所以将两者进行交换)
            exc(a, i, j);
        }
        // 将基准放到分界点
        if (lo != j) {
            exc(a, lo, j);
        }
        return j;
    }

    private static void exc(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
