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
import java.util.LinkedList;
import java.util.Queue;

public class MeiTuan15 {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int row, col;
    static int xs, ys, xt, yt;
    static int[][] a;
    static int[][] b;             // 十字路口的属性
    static boolean[][] visited;      // 节点是否已经被走过
    static int[] direction = new int[]{0, -1, 1};   // 移动方向

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        row = nextInt();
        col = nextInt();
        xs = nextInt();
        ys = nextInt();
        xt = nextInt();
        yt = nextInt();
        a = new int[row + 1][col + 1];
        b = new int[row + 1][col + 1];
        visited = new boolean[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                a[i][j] = nextInt();
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                b[i][j] = nextInt();
            }
        }

        int cost = 0;   // 初始化花费的时间
        visited[xs][ys] = true;
        out.println(bfs(cost));
        out.flush();
        out.close();
    }

    private static int bfs(int cost) {
        // 用于存储同一时间点可能到达的节点
        Queue<int[]> queue = new LinkedList<>();
        // 先把起点加入队列
        queue.offer(new int[]{xs, ys});
        while (!queue.isEmpty()) {
            int len = queue.size();   // 当前时刻有len个可能的位置
            while (len-- > 0) {
                int[] curPos = queue.poll();
                // 找到了小团，直接返回耗时
                if (curPos[0] == xt && curPos[1] == yt) {
                    return cost;
                }
                // 在当前位置尝试移动
                for (int j = 0; j < direction.length; j++) {
                    int remainder = cost % (a[curPos[0]][curPos[1]] + b[curPos[0]][curPos[1]]);
                    int x = curPos[0];
                    int y = curPos[1];
                    if (remainder < a[x][y]) {
                        // 时间处于[k*aij+k*bij), (k+1)*aij+k*bij)
                        x += direction[j];
                    } else {
                        // 时间处于[(k+1)*aij+k*bij), (k+1)*aij+(k+1)*bij)
                        y += direction[j];
                    }
                    // 移动位置不合法
                    if (x < 1 || x > row || y < 1 || y > col) {
                        continue;
                    }
                    // 如果下一个位置还没有走过或者当前时刻不进行移动，就往队列中添加节点
                    if (!visited[x][y] || j == 0) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            cost++;
        }
        return cost;
    }
}
//5 5 2 4 4 3
//2 1 1 3 1
//1 4 2 3 1
//4 4 4 2 1
//3 1 1 2 4
//5 1 5 5 1
//5 3 4 1 3
//1 1 2 2 2
//2 1 4 4 5
//1 1 5 3 3
//3 2 1 3 3