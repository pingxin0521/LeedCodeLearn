package meituan;

import java.io.*;

/**
 * <pre>
 *
 *  Created by pingxin on 2022/3/1.
 * </pre>
 *
 * @author pingxin
 * @date 2022/3/1
 */
public class MeiTuan02 {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }


    /**
     * 前缀和
     * TreeSet: 查询分割点的左右边界
     * Map将完成以下工作：
     * <p>
     * 首先将包含分割点的区间和SegSum的数量减1，因为它将被分割点拆开，若数量为 1，则直接删除；
     * 将分割后得到的 左右区间和加入其中；
     * 返回容器中的最大key，其为当前场上存在的 最大区间和。
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = nextInt();
        }

        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = nextInt() - 1;
        }
        int[] ans = new int[n];
        UF uf = new UF(n);
        boolean[] visited = new boolean[n];
        // ans[n-1]肯定是0，所以从倒数第二开始
        for (int i = n - 2; i >= 0; i--) {
            // 注意order还是从n-1开始的，所以取order[i+1]
            int idx = order[i + 1];
            visited[idx] = true;
            uf.weight[idx] = weight[idx];
            // 尝试和左右合并
            if (0 <= idx - 1 && visited[idx - 1]) {
                uf.union(idx - 1, idx);
            }
            if (idx + 1 < n && visited[idx + 1]) {
                uf.union(idx, idx + 1);
            }
            // ans[i]为之前的最大值或者当前联通组的sum
            ans[i] = Math.max(ans[i + 1], uf.getUnionSum(idx));
        }

        for (int i : ans) {
            out.println(i);
        }
        out.flush();
        out.close();
    }

    public static class UF {
        int[] parent, weight;

        public UF(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            // 合并时需要把被合并组的总重量加上
            parent[rootY] = rootX;
            weight[rootX] += weight[rootY];
        }

        public int getUnionSum(int x) {
            int rootX = find(x);
            return weight[rootX];
        }
    }
}
