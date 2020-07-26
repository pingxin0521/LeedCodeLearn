package leetcode.week05.day05;

/**
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.val == 0 && root.left == null && root.right == null) {
            root = root.left;
        } else {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        }

        if (root != null && root.val == 0 && root.left == null && root.right == null) {
            root = root.left;
        }

        return root;
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
