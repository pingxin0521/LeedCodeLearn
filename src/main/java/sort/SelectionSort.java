package sort;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class SelectionSort {
    public static void selectionSort(int[] arr, int n) {
        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
        for (int i = 0; i < n - 1; i++) {
            // 无序列表中最小元素的下标
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // 在无序列表中查找最小元素的小标并记录
                if (arr[j]<arr[minIndex])
                {
                    minIndex=j;
                }
            }
            // 将最小元素交换到本次循环的前端
            BubbleSort.swap(arr,minIndex,i);
        }
    }
}
