package sort;

/**
 * 冒泡排序
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class BubbleSort implements ISort {

    //优化一
    //在交换的地方加一个标记，如果那一趟排序没有交换元素，说明这组数据已经有序，不用再继续下去。
    //优化二
    //记下最后一次交换的位置，后边没有交换，必然是有序的，然后下一次排序从第一个比较到上次记录的位置结束即可。
    //优化三
    //一次排序可以确定两个值，正向扫描找到最大值交换到最后，反向扫描找到最小值交换到最前面
    @Override
    public <T extends Comparable<T>> void sort(T[] arr, int s, int e) {
        //需要排序的长度小于2，直接返回
        int len = e - s;
        if (len < 2) {
            return;
        }
        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
        int i = s;
        int j = s;
        int n = s;//同时找最大值的最小需要两个下标遍历
        boolean flag = false;
        int pos = s;//用来记录最后一次交换的位置
        int k = e - 1;
        for (i = s; i < e - 1; i++)//确定排序趟数
        {
            pos = s;
            flag = false;
            //正向寻找最大值
            for (j = n; j < k; j++)//确定比较次数
            {
                if (less(arr[j + 1], arr[j])) {
                    //交换
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;//加入标记
                    pos = j;//交换元素，记录最后一次交换的位置
                }
            }
            if (!flag)//如果没有交换过元素，则已经有序,直接结束
            {
                return;
            }
            k = pos;//下一次比较到记录位置即可
            //反向寻找最小值
            for (j = k; j > n; j--) {
                T tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                flag = true;
            }
            n++;
            if (!flag)//如果没有交换过元素，则已经有序,直接结束
            {
                return;
            }
        }
    }

//    /**
//     * 排序，排序arr中 [s,e)数据
//     *
//     * @param arr
//     * @param s
//     * @param e
//     */
//    @Override
//    public <T extends Comparable<T>> void sort(T[] arr, int s, int e)  {
//        //需要排序的长度小于2，直接返回
//        int n = e - s;
//        if (n < 2) {
//            return;
//        }
//        // 排序趟数，最后一个元素不用比较所以是 (n-1) 趟
//        for (int i = s; i < e - 1; i++) {
//            // 每趟比较的次数，第 i 趟比较 (n-1-i) 次
//            for (int j = s; j < e - i - 1; j++) {
//                // 比较相邻元素，若逆序则交换
//                if (less(arr[j + 1], arr[j])) {
//                    exch(arr, j, j + 1);
//                }
//            }
//        }
//    }

}
