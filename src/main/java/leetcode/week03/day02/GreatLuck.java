package leetcode.week03.day02;

import java.util.Scanner;

/**
 * 知识点：位运算、计数
 * 题意：给一个数组。计算对所有数而言两两位与运算求和。
 * https://ac.nowcoder.com/acm/contest/4853/A
 *
 * https://blog.nowcoder.net/n/057c92a6fdf2456c8689aa8cc0f8b8db
 * 由于数组长度为 10^5，显然不能 O(n^2)暴力求解。可以从位与运算的性质着手：两个数进行位于运算后，只有当某一位（二进制意义上）都是1的时候，位与之后才会变成1，否则就是0。
 * 最终只需要统计每个数对每个二进制计数的贡献即可。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day02
 * hyp create at 20-3-27
 **/
public class GreatLuck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        long[] tmp = new long[33];
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            int j = 0;
            while (k > 0) {
                tmp[j++] += k % 2;
                k = k / 2;
            }
        }
        long res = 0;

        for (int i = 0; i < tmp.length; i++) {
            res += (1 << i) * tmp[i] * tmp[i];
        }
        System.out.println(res);
    }
}
