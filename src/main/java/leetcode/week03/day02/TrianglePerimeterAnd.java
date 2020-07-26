package leetcode.week03.day02;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/4853/B
 * <p>
 * 知识点：计数
 * 题意：给定n个点，求所有三角形的周长之和，三角形的边长取曼哈顿距离。
 * 思路：这道题其实和A题有异曲同工之妙，都是统计后进行整体运算。这道题只需要统计每条边被计算多少次（答案显然是 n-2 次）即可。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day02
 * hyp create at 20-3-27
 **/
public class TrianglePerimeterAnd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] data = new long[n][2];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            data[i][0] = in.nextLong();
            data[i][1] = in.nextLong();
            in.nextLine();
        }
        int mod = 998244353;
        long m = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                m += (Math.abs(data[i][0] - data[j][0]) +
                        Math.abs(data[i][1] - data[j][1])) % mod * (n - 2);
                m %= mod;
            }
        }

        System.out.println(m);

    }
}
