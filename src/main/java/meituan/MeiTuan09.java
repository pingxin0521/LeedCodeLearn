package meituan;

/**
 * <pre>
 *
 * https://leetcode-cn.com/problems/GXV5dX/
 *  Created by pingxin on 2022/2/28.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/28
 */

import java.io.*;

public class MeiTuan09 {

    static final int mod = 998244353;
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * 这题的题解没有解释很清楚dp定义的, 我稍微解释一下:
     * <p>
     * dp[i][j]的定义为: 在第i个物品价格刚好为j的方法数量.
     * <p>
     *    初始值 : 只有一个位置的时候，也就是f[1][1~n]=1
     * 那么状态转移方程就是: 枚举上一个物品的价格, 由当前物品是上一个物品价格的倍数来得到当前的状态
     * <p>
     * dp[i][j] = dp[i-1][j的约数们]
     * <p>
     * // 第4个商品价格为4, 那么就需要第3个商品价格为4的约数, 也就是1, 2, 4
     * dp[4][4] = dp[3][1] + dp[3][2] + dp[3][4]
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = j; k <= n; k += j) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][j]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + dp[m][i]) % mod;
        }
        out.println(res);

        out.flush();
        out.close();
    }
}
