package meituan;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * https://leetcode-cn.com/problems/Uo7Dr5/
 *  Created by pingxin on 2022/3/1.
 * </pre>
 *
 * @author pingxin
 * @date 2022/3/1
 */
public class MeiTuan05 {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    private static int n, k;
    private static Map<Integer, List<Integer>> adj = new HashMap<>();
    private static int[] level;
    private static boolean[] vis;
    private static int mod = 1000000007;

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        n = nextInt();
        k = nextInt();

        // 构建图
        for (int i = 0; i < n - 1; i++) {
            int x = nextInt();
            int y = nextInt();
            adj.putIfAbsent(x, new ArrayList<>());
            adj.putIfAbsent(y, new ArrayList<>());
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        level = new int[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            level[i] = nextInt();
        }
        // 枚举从一个点开始的所有连通图
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + dfs(i, i)) % mod;
        }
        out.println(ans);

        out.flush();
        out.close();
    }

    private static long dfs(int cur, int start) {
        vis[cur] = true;
        long ans = 1;
        for (int next : adj.get(cur)) {
            if (vis[next]) continue;
            // 只找level比自己大的或者level相等，但是序号比自己大的，避免重复计算
            if (
                    (level[next] > level[start] && level[next] - level[cur] <= k)||
                            (level[next]==level[start]&&next>start)
            ){
                ans = (ans+ans*(dfs(next,start))) % mod;
            }
        }
        vis[cur] = false;
        return ans;
    }
}

