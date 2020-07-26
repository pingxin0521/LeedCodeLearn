package sort;

import java.util.Arrays;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {43, 13, 15, 28, 20, 63, 18, 59};
        bubbleSort2(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    //从小到大
    public static void bubbleSort1(int[] arr, int n) {
        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
        for (int i = 0; i < n - 1; i++) {
            // 每趟比较的次数，第 i 趟比较 (n-1-i) 次
            for (int j = 0; j < n - i - 1; j++) {
                // 比较相邻元素，若逆序则交换
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //优化一
    //在交换的地方加一个标记，如果那一趟排序没有交换元素，说明这组数据已经有序，不用再继续下去。
    //优化二
    //记下最后一次交换的位置，后边没有交换，必然是有序的，然后下一次排序从第一个比较到上次记录的位置结束即可。
    //优化三
    //一次排序可以确定两个值，正向扫描找到最大值交换到最后，反向扫描找到最小值交换到最前面
    public static void bubbleSort11(int[] arr, int len) {
        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
        int i = 0;
        int j = 0;
        int n = 0;//同时找最大值的最小需要两个下标遍历
        int flag = 0;
        int pos = 0;//用来记录最后一次交换的位置
        int k = len - 1;
        for (i = 0; i < len - 1; i++)//确定排序趟数
        {
            pos = 0;
            flag = 0;
            //正向寻找最大值
            for (j = n; j < k; j++)//确定比较次数
            {
                if (arr[j] > arr[j + 1]) {
                    //交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = 1;//加入标记
                    pos = j;//交换元素，记录最后一次交换的位置
                }
            }
            if (flag == 0)//如果没有交换过元素，则已经有序,直接结束
            {
                return;
            }
            k = pos;//下一次比较到记录位置即可
            //反向寻找最小值
            for (j = k; j > n; j--) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                flag = 1;
            }
            n++;
            if (flag == 0)//如果没有交换过元素，则已经有序,直接结束
            {
                return;
            }
        }
    }


    //从大到小
    public static void bubbleSort2(int[] arr, int n) {
        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
        for (int i = 0; i < n - 1; i++) {
            // 每趟比较的次数，第 i 趟比较 (n-1-i) 次
            for (int j = 0; j < n - i - 1; j++) {
                // 比较相邻元素，若逆序则交换
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    public static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
