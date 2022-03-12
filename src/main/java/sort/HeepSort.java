package sort;

/**
 * 堆排序
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class HeepSort implements ISort {

    /**
     * 排序，排序arr中 [s,e)数据
     *
     * @param arr
     * @param s
     * @param e
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr, int s, int e) {
        //需要排序的长度小于2，直接返回
        int n = e - s;
        if (n < 2) {
            return;
        }
        // 构造一个堆有序
        for (int i = n / 2; i >= 0; i--) {
            sink(arr, s + i, s + n - 1);
        }

        n = n - 1;
        // 然后进行下沉排序
        while (n > 0) {
            exch(arr, s, n--);
            sink(arr, s, s + n);
        }

    }

    private <T extends Comparable<T>> void sink(T[] a, int k, int n) {
        // 满足向下移动的条件
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            // 从 a[j]和a[j+1]中a比较出较大的元素
            if (j < n - 1 && less(a[j], a[j + 1])) {
                j++;
            }
            if (less(a[j], a[k])) {
                break;
            }
            // 将大的元素移动到上面去
            exch(a, k, j);
            k = j;
        }
    }
}
