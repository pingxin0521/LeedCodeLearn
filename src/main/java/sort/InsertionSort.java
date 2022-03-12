package sort;

/**
 * 插入排序
 * 对于 0 到 N-1 之间的每一个 i，将 a[i] 与 a[0] 到 a[i-1] 中比它小的所有元素依次有序地交换。 在索引 i 由左向右变化的过程中，它左侧的元素总是有序的，所以当 i 到达数组的右端时排序就完成了
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class InsertionSort implements ISort {

    @Override
    public <T extends Comparable<T>> void sort(T[] a, int s, int e)  {
        //需要排序的长度小于2，直接返回
        int n = e - s;
        if (n < 2) {
            return;
        }
        // 排序趟数，第一个元素不用比较所以是 (n-1) 趟
        for (int i = s + 1; i < e; i++) {
            // 如果a[j]比前面的数字小，则a[j]向前挪
            for (int j = i; j > s && (less(a[j], a[j - 1])); j--) {
                exch(a, j, j - 1);
            }
        }
    }

}
