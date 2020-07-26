package leetcode.week05.day05;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class Flatten {
    //解法1：使用链表保存先序遍历
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> res = new LinkedList<TreeNode>();
        //前序遍历整棵二叉树
        dfs(root, res);
        TreeNode head = res.removeFirst();
        head.left = null;
        //遍历链表，将链表中的TreeNode节点前后串联起来
        while (res.size() > 0) {
            TreeNode tmp = res.removeFirst();
            tmp.left = null;
            head.right = tmp;
            head = head.right;
        }
    }

    //前序遍历整棵二叉树，并将遍历的结果放到数组中
    void dfs(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        res.add(root);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    //解法2，栈
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        TreeNode pre = new TreeNode(-1);
        while (!stack.isEmpty()) {
            //用栈作为辅助数据结构，从栈中弹出元素后
            //先将右节点放到栈中，再将左节点放入栈中，模拟前序遍历
            TreeNode tmp = stack.removeLast();
            pre.left = null;
            pre.right = tmp;
            //先放入右节点，再放入左边点，顺序不能反了
            if (tmp.right != null) {
                stack.add(tmp.right);
            }
            if (tmp.left != null) {
                stack.add(tmp.left);
            }
            pre = pre.right;
        }
    }

    //解法3
    public void flatten(TreeNode root) {
        helper(root);
    }

    TreeNode pre = null;

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        //右节点-左节点-根节点 这种顺序正好跟前序遍历相反
        //用pre节点作为媒介，将遍历到的节点前后串联起来
        helper(root.right);
        helper(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
