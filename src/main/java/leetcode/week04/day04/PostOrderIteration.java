package leetcode.week04.day04;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day04
 * hyp create at 20-6-22
 **/
public class PostOrderIteration {
    public List<Integer> postOrderIteration2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }
}
