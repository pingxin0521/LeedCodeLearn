package meituan;

/**
 * <pre>
 *
 * https://leetcode-cn.com/problems/yqj8Su/
 *  Created by pingxin on 2022/2/28.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/28
 */

import java.io.*;

public class MeiTuan10 {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * TopK 小顶堆
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        int m = nextInt();
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            int l = i, r = m + 1;
            while (l < r) {
                int mid = l + (r - l)/2;
                if (ok(i, mid, n, arr)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res += m - l + 1;
            if (l == m + 1) {
                break;
            }
        }
        out.println(res);
        out.flush();
        out.close();
    }

    /**
     * 根据 (x in arr) && (l > x || r < x) 筛选原数组 arr 得到子序列 seq
     * 如果 seq 是非递减的序列，则代表 <l, r> 是默契的。
     *
     * @param l
     * @param r
     * @param n
     * @param arr
     * @return
     */
    static boolean ok(int l, int r, int n, int[] arr) {
        int p = -1;
        for (int i = 0; i < n; i++) {
            if (l > arr[i] || r < arr[i]) {
                if (arr[i] < p) {
                    return false;
                }
                p = arr[i];
            }
        }
        return true;
    }
}
//5 5
//4 1 4 1 2