package meituan;

import java.io.*;
import java.util.Arrays;

/**
 * <pre>
 *
 * https://leetcode-cn.com/problems/TOVGD1/
 *  Created by pingxin on 2022/3/1.
 * </pre>
 *
 * @author pingxin
 * @date 2022/3/1
 */
public class MeiTuan04 {

    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(sc.readLine());
        // 避免检查复制后边界超出
        int[] a = new int[n * 2];
        int[] b = new int[n * 2];
        // 赋初值
        Arrays.fill(b,-1);
        Arrays.fill(a,-1);

        String[] nums = sc.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(nums[i]);
        }
        // 操作数
        int m = Integer.parseInt(sc.readLine());
        for (int i = 0; i < m; i++) {
            // 暂存操作，判断操作为读（2）or赋值（1）
            String[] ops = sc.readLine().split(" ");
            if ("2".equals(ops[0])) {
                int idx = Integer.parseInt(ops[1]) - 1;
                //查询操作：2 x，表示询问B序列下标 x 处的值是多少。
                out.println(b[idx]);
            } else {
                //粘贴操作： 1 k x y，表示把 A 序列中从下标 x 位置开始的连续 k 个元素粘贴到 B 序列中从下标 y 开始的连续 k 个位置上
                int len = Integer.parseInt(ops[1]);
                int start = Integer.parseInt(ops[2]) - 1;
                int end = Integer.parseInt(ops[3]) - 1;
                System.arraycopy(a, start, b, end, len);
            }
        }
        out.flush();
        out.close();
    }
}
