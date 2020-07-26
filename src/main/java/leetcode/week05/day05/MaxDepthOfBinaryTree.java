package leetcode.week05.day05;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        } else {
            return 1 + maxDepth(root.right) + maxDepth(root.left);
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
