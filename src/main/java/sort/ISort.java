package sort;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created By pingx on 2020/12/13.
 * At sort
 */
public interface ISort {
    /**
     * 排序，排序arr中 [s,e)数据
     *
     * @param arr
     * @param s
     * @param e
     * @param <T>
     */
    <T extends Comparable<T>> void sort(T[] arr, int s, int e);

    /**
     * Auxiliary method for algorithms what wanted to work with lists from JCF
     *
     * @param unsorted - a list should be sorted
     * @return a sorted list
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> List<T> sort(List<T> unsorted, int s, int e) {
        T[] ts = unsorted.toArray((T[]) new Comparable[unsorted.size()]);
        sort(ts, s, e);
        return Arrays.asList(ts);
    }

    /**
     * 比较值
     *
     * @param a   a
     * @param b   b
     * @param <T> 类型
     * @return
     */
    default <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo((T) b) < 0;
    }

    /**
     * 交换位置
     *
     * @param a   原数组
     * @param i   i
     * @param j   j
     * @param <T> 类型
     */
    default <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    default <T extends Comparable<T>> void show(T[] a, PrintStream pst) {
        for (Comparable<T> t : a) {
            pst.print(t + "\t");
        }
        pst.println();
    }

    /**
     * 判断是否排序完成
     *
     * @param a   数组
     * @param <T> 类型
     * @return 是否已排序完成
     */
    default <T extends Comparable<T>> boolean isSorted(T[] a) {
        return isSorted(a, true);
    }

    /**
     * 判断是否排序完成
     *
     * @param a   数组
     * @param asc 是否是升序
     * @param <T> 类型
     * @return 是否已排序完成
     */
    default <T extends Comparable<T>> boolean isSorted(T[] a, boolean asc) {
        for (int i = 1; i < a.length; i++) {
            if (asc) {
                if (less(a[i], a[i - 1]))
                    return false;
            } else {
                if (!less(a[i], a[i - 1]))
                    return false;
            }
        }
        return true;
    }
}
