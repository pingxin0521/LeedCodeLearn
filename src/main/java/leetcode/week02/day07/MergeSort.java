package leetcode.week02.day07;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/evaluate/2598/B
 * 来源：牛客网
 * <p>
 * 归并排序是一个基于分治思想的经典排序算法，在最坏情况下，它给n个元素排序的时间复杂度是O(nlogn)。它的一种实现的伪代码如下：
 * List mergeSort(List a)
 * 1. if size(a) <= 1, return a
 * 2. 将a划分成b和c两个子数组
 * if size(a) = 2*k, b包含a的前k个元素，c包含a的后k个元素
 * if size(a) = 2*k+1, b包含a的前k个元素，c包含a的后k+1个元素
 * 3. List sb = mergeSort(b)
 * List sc = mergeSort(c)
 * 4. return merge(sb,sc)
 * List merge(List b, List c)
 * 1. List a=[]
 * 2. 当b和c非空时，比较b和c的第一个元素
 * b的第一个元素更小: 将b的第一个元素从b中删除并加到a的末尾
 * c的第一个元素更小: 将c的第一个元素从c中删除并加到a的末尾
 * 两者相等:将b和c的第一个元素分别从b、c中删除并加到a的末尾
 * （重复执行该步骤直到b或者c为空）
 * 3. 把b和c中非空的那个数组加到a的末尾
 * 4. return a
 * 现在牛妹想知道用上述归并排序的算法对一个数组a进行排序的过程中进行了多少次比较，请你写个程序帮她求出来。
 * <p>
 * 输入描述:
 * 第一行输入一个整数，表示待排序的数组大小
 * 第二行N个整数，表示数组a里的元素
 * ( 1\leq N\leq 50,-2^{31}\leq a_{1},a_{2},…,a_{n}\leq 2^{31}-1）(1≤N≤50,−2
 * 31
 * ≤a
 * 1
 * ​
 * ,a
 * 2
 * ​
 * ,…,a
 * n
 * ​
 * ≤2
 * 31
 * −1）
 * 输出描述:
 * 输出一个整数，表示用上述排序算法对a排序过程中进行比较操作的次数
 * 示例1
 * 输入
 * 复制
 * 4
 * 2 1 4 3
 * 输出
 * 复制
 * 4
 * 说明
 * {2 1 4 3}分为{2 1}{4 3}，{2 1}分为{2} {1}，{4 3}分为{4}{3}，将{2}{1}合并为{1 2}需要一次比较，{4}{3}合并为{3 4}需要一次比较，{1 2}{3 4}合并需要2次比较（1和3比较一次，2和3比较一次），共4此比较
 * 示例2
 * 输入
 * 复制
 * 7
 * 7 6 5 4 3 2 1
 * 输出
 * 复制
 * 11
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day07
 * hyp create at 20-3-25
 **/
public class MergeSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        mergeSort(arr);
        System.out.println(count);
    }

    public static int count = 0;

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            mergeSort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
            count++;
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
