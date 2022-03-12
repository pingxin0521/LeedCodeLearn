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
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeiTuan03 {

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
        int n = nextInt();
        int m = nextInt();

        // 1 订单号：1-n
        // 2 价格
        // 3 重量
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        for (int i = 0; i < n; i++) {
            int[] data = new int[2];
            data[0] = i + 1;
            // 跑腿价格 v
            // 商品重量 w kg
            // 跑腿价格和重量加价之和,商品每重 1kg ，代购费用要加 2 元
            data[1] = nextInt() + nextInt() * 2;

            queue.offer(data);
            while (queue.size() > m) {
                queue.poll();
            }

        }
        queue.stream()
                .map(data -> data[0])
                .sorted()
                .forEach(no -> out.print(no + " "));
        out.flush();
        out.close();
    }


    /**
     * 构建一个二维数组，然后使用自定义比较器进行排序，数组内第一个数表示订单编号，当「跑腿费+2*重量」相等时返回编号较小的那个，否则返回价值较大的那个。
     */
    public static void main2(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();

        // 1 订单号：1-n
        // 2 价格
        // 3 重量
        int[][] data = new int[n][3];
        for (int i = 0; i < n; i++) {
            data[i][0] = i + 1;
            // 跑腿价格 v
            data[i][1] = nextInt();
            // 商品重量 w kg
            data[i][2] = nextInt();

            // 跑腿价格和重量加价之和,商品每重 1kg ，代购费用要加 2 元
            data[i][1] = data[i][1] + data[i][2] * 2;
        }
        Arrays.sort(data, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = data[i][0];
        }
        Arrays.sort(ans);
        for (int i = 0; i < m; i++) {
            out.print(ans[i] + " ");
        }
        out.flush();
        out.close();
    }
}
