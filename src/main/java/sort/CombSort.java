package sort;

/**
 * 梳排序
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class CombSort implements ISort {

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
        int len = e - s;
        if (len < 2) {
            return;
        }
        // initialize gap
        int gap = e - s;
        // Initialize swapped as true to make sure that loop runs
        boolean swapped = true;
        // Keep running while gap is more than 1 and last iteration caused a swap
        while (gap != 1 || swapped) {
            // Find next gap
            gap = nextGap(gap);

            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i = 0; i < len - gap; i++) {
                if (less(arr[i + gap], arr[i])) {
                    // Swap arr[i] and arr[i+gap]
                    exch(arr, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    // To find gap between elements
    private int nextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }
}
