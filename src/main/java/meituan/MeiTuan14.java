package meituan;

/**
 * <pre>
 * https://leetcode-cn.com/problems/LMkFuT/
 *  Created by pingxin on 2022/2/28.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/28
 */

import java.io.*;
import java.util.Arrays;

public class MeiTuan14 {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * 输入：
     * - 输入第一行包含两个正整数x，y，分别表示 AB 队的人数。
     * - 输入第二行包含 x+y 个正整数，中间用空格隔开，第i个数字表示第i个人的实力值，每个人的实力值不会超过20000，保证任意两个人都不会有相同的实力值。
     * 输出：
     * - 输出包含一个长度为 x+y 的字符串，每个字符是 'A'或 'B'，表示某人应该被分在 A 或 B 队。如果存在多种答案，则输出字典序最小的字符串。
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        int x = nextInt();
        int y = nextInt();
        /**
         * 1.当两支队伍人数相同，怎么平均最后都一样，按序排就好了
         * 2.当队伍人数不一样的时候，让实力高的人去人少的队伍
         * 坑：可能出现实力值一样的两人，要分去两个不同的队伍，而要保证字典序最小
         *
         */
        char[] ans = new char[x + y];
        if (x == y) {
            Arrays.fill(ans, 0, x, 'A');
            Arrays.fill(ans, x , x + y, 'B');
        } else {
            int total = x + y;
            //二维数组，第一维记录索引，第二维记录实力值
            int[][] arr = new int[x + y][2];
            for (int i = 0; i < total; i++) {
                arr[i][0] = i;
                arr[i][1] = nextInt();
            }
            //按着索引，对字符数组赋值
            Arrays.fill(ans, 'B');
            if (x < y) {
                Arrays.sort(arr, (o1, o2) -> {
                    //索引从小到大，因为赋值A从前往后
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o2[1] - o1[1];//主排序，从大到小
                });
                for (int i = 0; i < x; i++) {
                    ans[arr[i][0]] = 'A';
                }
            } else {
                Arrays.sort(arr, (o1, o2) -> {
                    //索引从小到大，因为赋值A从后往前
                    if (o1[1] == o2[1]) {
                        return o2[0] - o1[0];
                    }
                    return o2[1] - o1[1];//主排序，从大到小
                });
                for (int i = x + y - 1; i >= y; i--) {
                    ans[arr[i][0]] = 'A';
                }
            }
        }

        // 输出结果
        for (char i : ans) {
            out.print(i);
        }
        out.flush();
        out.close();
    }
}
//4 4
//5 6 4 2 3 8 1 7