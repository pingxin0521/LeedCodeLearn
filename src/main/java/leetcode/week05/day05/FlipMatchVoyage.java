package leetcode.week05.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/
 * <p>
 * 该题也是递归思想的应用。按照题目要求进行前序遍历，一旦遇到对应值与目标数组结果不同时，翻转遍历，接着继续遍历，如果最终结果依然不匹配则返回false，否则返回true。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class FlipMatchVoyage {
    private int index;
    private int[] voyage;
    private List<Integer> result;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        // index = 0;
        this.voyage = voyage;
        result = new ArrayList<>();
        dfs(root);
        // System.out.println("result = "+result);
        if (result.size() > 0 && result.get(result.size() - 1) == -1)
            return new ArrayList<Integer>(Arrays.asList(-1));
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val != voyage[index++]) {
            result.add(-1);
        } else {
            if (root.left != null && root.left.val != voyage[index]) {
                result.add(root.val);
                dfs(root.right);
                dfs(root.left);
            } else {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
