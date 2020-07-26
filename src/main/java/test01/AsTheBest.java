package test01;

import java.util.Scanner;

/**
 * 最好一样
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 给出一个序列包含n个正整数的序列A，然后给出一个正整数x，你可以对序列进行任意次操作的，每次操作你可以选择序列中的一个数字，让其与x做按位或运算。你的目的是让这个序列中的众数出现的次数最多。
 * <p>
 * 请问众数最多出现多少次。
 * <p>
 * 输入
 * 输入第一行仅包含两个正整数n和x，表示给出的序列的长度和给定的正整数。(1<=n<=100000,1<=x<=1000)
 * <p>
 * 接下来一行有n个正整数，即这个序列，中间用空格隔开。(1<=a_i<=1000)
 * <p>
 * 输出
 * 输出仅包含一个正整数，表示众数最多出现的次数。
 * <p>
 * <p>
 * 样例输入
 * 5 2
 * 3 1 3 2 5
 * 样例输出
 * 3
 * <p>
 * 提示
 * 样例解释
 * 例如如果序列中所有数字都不修改时，众数为3，3出现的次数为2，如果我们把两个3都做如题操作，序列会变为3，3，3，2，7，此时众数为3，出现次数为3，所以我们选择后者方案，输出众数出现的次数，即3。 其余内容不变。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-12
 **/
public class AsTheBest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        int[] hArr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
            int t = arr[i] | x;
            hArr[i] = t == arr[i] ? -1 : t;
        }


    }
}
