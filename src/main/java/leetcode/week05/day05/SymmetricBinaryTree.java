package leetcode.week05.day05;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 递归思想的一个简单应用，从以树的根节点的左右子节点为根开始进行深度优先搜索，依次判断两颗子树的左子树是否更与其右子树，右子树是否等于其左子树即可。如果采用迭代则只需使用层次遍历，判断每层元素是否满足镜像对称即可。
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode l,TreeNode r){
        if (l==null&&r==null){
            return true;
        }
        if (l==null||r==null)
            return false;
        return l.val==r.val&&check(l.left,r.right)&&check(l.right,r.left);
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
