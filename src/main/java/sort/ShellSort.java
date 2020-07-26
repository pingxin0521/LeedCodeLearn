package sort;

import java.util.Arrays;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class ShellSort {
    public static void shellSort(int[] a, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 直到间隔为 1
            // 按间隔 h 切分数组
            for (int i = h; i < n; i++) {
// 对 a[i], a[i-h], a[i-2*h], a[i-3*h]...使用插入排序
                int x = a[i];
                int j = i;
                while (j >= h && x < a[j - h]) {
                    a[j] = a[j - h];
                    j = j - h;
                }
                a[j] = x;
            }
            // 递减增量
            h /= 3;
        }
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int j = 0; (j + gap) < arr.length; j++) {
                for (int k = 0; (k + gap) < arr.length; k += gap) {
                    if (arr[k] > arr[k + gap]) {
                        BubbleSort.swap(arr, k, k + gap);
                        System.out.println("Sorting:  " + Arrays.toString(arr));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {43, 13, 15, 28, 20, 63, 18, 59};
        System.out.println("Begin:  " + Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
