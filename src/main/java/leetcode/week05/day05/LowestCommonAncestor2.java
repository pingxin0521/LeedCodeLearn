package leetcode.week05.day05;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * <p>
 * 从根节点开始遍历树
 * 如果节点 p 和节点 q 都在右子树上，那么以右孩子为根节点继续 1 的操作
 * 如果节点 p 和节点 q 都在左子树上，那么以左孩子为根节点继续 1 的操作
 * 如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 p 和节点 q 的 LCA 了
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

    //迭代
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
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
