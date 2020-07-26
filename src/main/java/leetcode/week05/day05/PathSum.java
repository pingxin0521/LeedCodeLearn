package leetcode.week05.day05;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * <p>
 * 1.从根节点 深度遍历 二叉树, 先序遍历 时,将该节点值存储至 path栈 中(vector实现),使用 path_value 累加 节点值。
 * 2.当遍历至 叶结点 时,检查 path_value值 是否为sum,若为sum,则将path进入 result结果中。
 * 3.在 后续遍历 时,将该节点值从path栈中 弹出 ,path_value 减去 节点值。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class PathSum {
    //递归，O(N)
    //最直接的方法就是利用递归，遍历整棵树：如果当前节点不是叶子，对它的所有孩子节点，递归调用 hasPathSum 函数，其中 sum 值减去当前节点的权值；如果当前节点是叶子，检查 sum 值是否为 0，也就是是否找到了给定的目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //迭代,O(N)
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null)
            return false;
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);

        TreeNode node;
        int curSum;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            curSum = sumStack.pollLast();
            if (node.left == null && node.right == null && curSum == 0) {
                return true;
            }
            if (node.right != null) {
                nodeStack.addLast(node.right);
                sumStack.addLast(curSum - node.right.val);
            }
            if (node.left != null) {
                nodeStack.addLast(node.left);
                sumStack.addLast(curSum - node.left.val);
            }
        }
        return false;
    }
}
