package test07;

import java.util.*;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class Test05 {
    public static void main(String[] args) {
        Test05 test05 = new Test05();
//        System.out.println(Arrays.deepToString(test05.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1)));

        System.out.println(test05.distinctEchoSubstrings("leetcodeleetcode"));

    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res.add(nums[i + 1]);
            }
        }

        int len = res.size();
        int[] ans = new int[len];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int p = Math.max(0, i - K); p < Math.min(n, i + K + 1); ++p) {
                    for (int q = Math.max(0, j - K); q < Math.min(m, j + K + 1); ++q) {
                        sum += mat[p][q];
                    }
                }
                ans[i][j] = sum;
            }
        }

        return ans;
    }

    int sum = 0;

    void dfs(TreeNode rt, int fa, int gfa) {
        if (rt == null) {
            return;
        }
        if (gfa != -1 && gfa % 2 == 0) {
            sum += rt.val;
        }
        dfs(rt.left, rt.val, fa);
        dfs(rt.right, rt.val, fa);

    }

    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        dfs(root, -1, -1);
        return sum;
    }

    public int distinctEchoSubstrings(String text) {
        int len = text.length();
        int cnt = 0;
        for (int k = 2; k < len; k += 2) {
            Set<String> res = new HashSet<>();
            for (int i = 0; i + k <= len; i++) {
                String tmp = text.substring(i,i+ k / 2);
                boolean flag = true;
                if (res.contains(tmp))
                {
                    continue;
                }
                for (int pos = 0; pos < k / 2; pos++) {
                    if (text.charAt(i + pos) != text.charAt(i + k / 2 + pos)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                {
                    res.add(tmp);
                }
            }
            cnt+=res.size();
        }
        return cnt;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
