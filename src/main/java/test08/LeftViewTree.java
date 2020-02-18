package test08;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：打印从左往右看到的二叉树（就是打印每层第一个节点）
 * <p>
 * 思路：按层换行打印改动一下，加个标记位解决。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-14
 **/
public class LeftViewTree {


    public void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last;
        TreeNode nlast;
        last = root;    //记录当前层最后一个节点
        nlast = root;    //记录下一层的最后一个节点
        int flag = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.peek();
            if (flag == 1) {
                System.out.print(queue.poll().val + " ");
                flag = 0;
            } else {
                queue.poll();
            }

            if (t.left != null) {
                queue.offer(t.left);
                nlast = t.left;
            }
            if (t.right != null) {
                queue.offer(t.right);
                nlast = t.right;
            }
            // 如果当前输出结点是最右结点，那么换行
            if (last == t) {
                flag = 1;
                last = nlast;
            }
        }
    }

    public static void main(String[] args) {

        LeftViewTree test = new LeftViewTree();
        // 构建二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        test.printTree(root);
    }

}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
