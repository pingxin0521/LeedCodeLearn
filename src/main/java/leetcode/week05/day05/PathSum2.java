package leetcode.week05.day05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class PathSum2 {
    //回溯+剪枝
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        findSum(root, 0, sum, path, res);
        return res;
    }

    private void findSum(TreeNode root, int num, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        num += root.val;
        path.addLast(root.val);
        if (root.left == null && root.right == null && num == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        findSum(root.left, num , sum, path, res);
        findSum(root.right, num , sum, path, res);
        num -= root.val;
        path.removeLast();
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
