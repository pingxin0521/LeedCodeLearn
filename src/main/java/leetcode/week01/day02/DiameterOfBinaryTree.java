package leetcode.week01.day02;


/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class DiameterOfBinaryTree {
    int res = 0;

    /**
     * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/java-shen-du-you-xian-bian-li-dfs-by-sugar-31/
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    // 函数dfs的作用是：找到以root为根节点的二叉树的最大深度
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rigthDepth = dfs(root.right);
        res = Math.max(res,leftDepth + rigthDepth);
        return Math.max(leftDepth,rigthDepth) + 1;
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