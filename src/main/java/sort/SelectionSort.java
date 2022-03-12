package sort;

/**
 * 选择排序
 * 将第 i 小的元素放到 a[i] 之中。数组的第 i 个位置的左边是 i 个最小的元素且它们不会再 被访问。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class SelectionSort implements ISort {
    /**
     * 排序，排序arr中 [s,e)数据
     *
     * @param arr
     * @param s
     * @param e
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr, int s, int e)  {
        //需要排序的长度小于2，直接返回
        int n = e - s;
        if (n < 2) {
            return;
        }
        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
        for (int i = s; i < e - 1; i++) {
            // 无序列表中最小元素的下标
            int minIndex = i;
            for (int j = i + 1; j < e; j++) {
                // 在无序列表中查找最小元素的小标并记录
                if (less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            // 将最小元素交换到本次循环的前端
            exch(arr, minIndex, i);
        }
    }
}
