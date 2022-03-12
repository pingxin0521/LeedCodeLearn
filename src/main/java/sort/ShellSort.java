package sort;

/**
 * shell排序
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class ShellSort implements ISort {
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
        //获取分组
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 直到间隔为 1
            // 按间隔 h 切分数组
            for (int i = s + h; i < e; i++) {
                // 对 a[i], a[i-h], a[i-2*h], a[i-3*h]...使用插入排序
                T x = arr[i];
                int j = i;
                while (j >= s + h && less(x, arr[j - h])) {
                    arr[j] = arr[j - h];
                    j = j - h;
                }
                arr[j] = x;
            }
            // 递减增量
            h /= 3;
        }
    }
}
