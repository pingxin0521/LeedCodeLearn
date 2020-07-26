package sort;

import java.util.Arrays;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class CombSort {

    public static void main(String[] args) {
        int[] arr = {43, 13, 15, 28, 20, 63, 18, 59};
        combSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] combSort(int[] a) {
        int n = a.length;
        int step = n;
        int k;
        // 第一部分
        while ((step /= 1.3) > 1) {
            for (int i = n - 1; i >= step; i--) {
                k = i - step;
                if (a[k] > a[i]) {
                    BubbleSort.swap(a, k, i);
                }
            }
        }
        // 第二部分：进行冒泡排序
        BubbleSort.bubbleSort1(a, a.length);
        return a;
    }
}
