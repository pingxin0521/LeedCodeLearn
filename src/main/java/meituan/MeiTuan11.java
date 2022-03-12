package meituan;

/**
 * <pre>
 * https://leetcode-cn.com/problems/0JzXQB/
 *  Created by pingxin on 2022/2/28.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/28
 */

import java.io.*;
import java.util.Arrays;

public class MeiTuan11 {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * 贪心： 按照组合价格排序
     * @param args
     */
    public static void main(String[] args) throws IOException {
        long max = 0;
        long[][] prices = new long[3][2];
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = nextInt();
        }
        for (int i = 0; i < 3; i++) {
            prices[i][0] = i;
            prices[i][1] = nextInt();
        }

        Arrays.sort(prices, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return (int) (o1[0] - o2[0]);
            }
            return (int) (o2[1] - o1[1]);
        });

        for (int i = 0; i < 3; i++) {
            if (nums[3] >= nums[(int) prices[i][0]]) {
                max += nums[(int) prices[i][0]] * prices[i][1];
                nums[3] -= nums[(int) prices[i][0]];
            } else {
                max += nums[3] * prices[i][1];
                nums[3] = 0;
            }
        }
        out.println(max);
        out.flush();
        out.close();
    }
}
//2 3 4 5 6 7 8