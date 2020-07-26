package leetcode.week05.day05;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * 选取其中一个根节点作为返回值的根节点。然后应用深度优先搜索的思想，采用相同顺序同时遍历两棵树，如果当前节点均存在则相加，否则则选取含有值的节点。
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        return t1;
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
