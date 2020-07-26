package sort;

import java.util.Arrays;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class HeepSort {

    public static void main(String[] args) {
        int[] arr = {43, 13, 15, 28, 20, 63, 18, 59};
        System.out.println("Begin:  " + Arrays.toString(arr));
        heepSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void heepSort(int[] a) {
        int n = a.length;
        // 构造一个堆有序
        for (int i = n / 2; i >= 0; i--) {
            sink(a, i, n - 1);
        }
        n = n - 1;
        // 然后进行下沉排序
        while (n > 0) {
            BubbleSort.swap(a, 0, n--);
            sink(a, 0, n);
        }

    }

    public static void sink(int[] a, int k, int n) {
        // 满足向下移动的条件
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            // 从 a[j]和a[j+1]中a比较出较大的元素
            if (j < n - 1 && a[j + 1] > a[j]) {
                j++;
            }
            if (a[j] < a[k]) {
                break;
            }
            // 将大的元素移动到上面去
            BubbleSort.swap(a, k, j);
            k = j;
        }
        System.out.println("Sorting:  " + Arrays.toString(a));

    }
}
