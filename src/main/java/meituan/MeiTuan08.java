package meituan;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *  https://leetcode-cn.com/problems/vSYUMc/
 *  Created by pingxin on 2022/3/1.
 * </pre>
 *
 * @author pingxin
 * @date 2022/3/1
 */
public class MeiTuan08 {
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));


    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * 可将该题视作小美所在起点为根的树，则小团必然无法通过小美所在根节点到达其他子树中，下一步移动可以分为两种情况：
     *
     * 小团所在点非子树根节点，则小美下一步移动至小团所在子树的根节点，进一步缩小小团可达子树大小，而小团需要向父节点移动尽力扩大子树大小。
     * 小团正好位于子树根节点，那么在小美到达该节点前小团可以前往任意子树中。
     * 换言之，只要小美能够先到达的点，小团就必然无法到达，只要计算小美与小团到达各点的距离，找出所有离小美更远的点，就是小团能够到达的所有点，这其中距离小美最远的点的距离就是答案。
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 1; i < n; i++) {
            int a = nextInt(), b = nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distx = new int[n + 1];
        int[] disty = new int[n + 1];
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(x);
        qy.offer(y);
        dfs(qx, distx, graph);
        dfs(qy, disty, graph);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (distx[i] > disty[i]) {
                ans = Math.max(ans, distx[i]);
            }
        }
        out.println(ans);
        out.flush();
        out.close();
    }

    static void dfs(Queue<Integer> q, int[] dist, List<List<Integer>> graph) {
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Integer next : graph.get(now)) {
                if (dist[next] == 0) {
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}

