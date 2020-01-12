package test06;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test06
 * hyp create at 19-10-31
 **/
public class Sort {
    private static Random random = new Random();

    public static void main(String[] argv) {
        int[] arr = makeData();
        //testTime("冒泡排序", arr, arr.length);
        testTime("希尔排序", arr, arr.length);
    }

    private static int[] makeData() {
        int len = 10;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt() % 100000;
        }
        return arr;
    }


    private static void testTime(String name, int[] arr, int target) {
        System.out.println("算法名称：" + name);
        System.out.println("排序前:" + Arrays.toString(arr));
        long d = System.currentTimeMillis();
        shellSort(arr);
//        insertionSort(arr, target);
        System.out.println("排序：" + Arrays.toString(arr));
        System.out.println("耗时:" + (System.currentTimeMillis() - d));
    }

    public static void bubbleSort(int[] arr, int n) {
        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
        for (int i = 0; i < n - 1; i++) {
            // 每趟比较的次数，第 i 趟比较 (n-1-i) 次
            for (int j = 0; j < n - i - 1; j++) {
                // 比较相邻元素，若逆序则交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr, int n) {
        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // 无序列表中最小元素的下标
            for (int j = i + 1; j < n; j++) {
                // 在无序列表中查找最小元素的小标并记录
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }    // 将最小元素交换到本次循环的前端
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void insertionSort(int[] a, int n) {
        //a[0]看做已排序
        for (int i = 1; i < n; i++) {
            int x = a[i];// 待插入元素
            int j = i - 1;// 插入的位置
            while (j >= 0 && a[j] > x) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = x;// 插入到下一个位置 j+1
        }
    }

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
                int x = a[i];// 待插入元素
                int j = i;
                while (j >= h && x < a[j - h]) {
                    a[j] = a[j - h];// 为待插入元素腾地
                    j = j - h;
                }
                a[j] = x; // 插入 x
            }
            // 递减增量
            h /= 3;
        }
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        for (; gap > 0; gap /= 2) {      //不断缩小gap，直到1为止
            for (int j = 0; (j + gap) < arr.length; j++) {     //使用当前gap进行组内插入排序
                for (int k = 0; (k + gap) < arr.length; k += gap) {
                    if (arr[k] > arr[k + gap]) {
                        int temp = arr[k + gap];      //交换操作
                        arr[k + gap] = arr[k];
                        arr[k] = temp;
                        System.out.println("Sorting:  " + Arrays.toString(arr));
                    }
                }
            }
        }
    }

    //递归归并排序
    public static void mergeSort(int[] a, int low, int high) {
        // 要排序的数组 a[low..high]
        if (low < high) {// 是否还能再二分 low >= high (0 或 1 个元素)
            int mid = low + (high - low) / 2; // 取中间值，避免 int 溢出
            mergeSort(a, low, mid); // 将左半边排序
            mergeSort(a, mid + 1, high); // 将右半边排序
            merge(a, low, mid, high); // 归并左右两边
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int n = high - low + 1; // 合并后元素总数
        int[] b = new int[n]; // 临时合并数组
        int left = low, // 左边有序序列起始下标
                right = mid + 1, // 右边有序序列起始下标
                bIdx = 0;
        // 按升序归并到新数组  b 中
        while (left <= mid && right <= high) {
            b[bIdx++] = (a[left] <= a[right]) ? a[left++] : a[right++];
        }
        // 右边序列已拷贝完毕，左边还有剩余，将其依次拷贝到合并数组中
        while (left <= mid) {
            b[bIdx++] = a[left++];
        }
        // 左边序列已拷贝完毕，右边还有剩余，将其依次拷贝到合并数组中
        while (right <= high) {
            b[bIdx++] = a[right++];
        }
        // 将归并后的数组元素拷贝到原数组适当位置
        for (int k = 0; k < n; k++) {
            a[low + k] = b[k];
        }
    }

}
