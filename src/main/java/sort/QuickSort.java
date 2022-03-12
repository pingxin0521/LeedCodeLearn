package sort;

/**
 * 快排
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-5
 **/
public class QuickSort implements ISort {

    /**
     * 进行切分，并进行交换
     *
     * @param array 数组
     * @param left  切分开始的位置
     * @param right 切分结束的位置
     * @return 返回分界点的位置
     */
    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];

        while (left <= right) {
            while (less(array[left], pivot)) {
                ++left;
            }
            while (less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                exch(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    private <T extends Comparable<T>> void doSort(T[] a, int lo, int h) {
        if (lo < h) {
            int pivot = partition(a, lo, h);
            doSort(a, lo, pivot - 1);
            doSort(a, pivot, h);
        }
    }


    /**
     * 排序，排序arr中 [s,e)数据
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] a, int lo, int h) {
        doSort(a, lo, h - 1);
    }
}
