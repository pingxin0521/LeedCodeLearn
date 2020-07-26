package sort;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in sort
 * hyp create at 20-3-5
 **/
public class InsertionSort {
    public static int[] insertSort(int a[]) {
        int n=a.length;
        for (int i = 0; i < n; i++) {
            // 如果a[i]比前面的数字小，则a[i]向前挪
            for (int j=i;j>0&&(a[j-1]>a[j]);j++)
            {
                BubbleSort.swap(a,j,j-1);
            }
        }
        return a;
    }


    public static void insertionSort(int[] a, int n) {
        //a[0]看做已排序
        for (int i = 1; i < n; i++) {
            int x=a[i];
            int j=i-1;
            while (j>0&&a[j]>x)
            {
                a[j+1]=a[j];
                j--;
            }
            // 插入到下一个位置 j+1
            a[j+1]=x;
        }
    }

}
