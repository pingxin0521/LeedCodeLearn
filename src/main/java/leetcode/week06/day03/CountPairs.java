package leetcode.week06.day03;

/**
 * https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs/
 *
 * 使用深度优先搜索，搜索所有叶子节点到当前节点的路径长度及其对应个数，存储到数组中，数组长度可设为distance。
 * 然后根据当前节点的左右子树的对应数组，找到长度之和小于等于distance-2的组合，相乘并加到结果中。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day03
 * hyp create at 20-7-26 下午3:15
 **/
public class CountPairs {
    int ans = 0;

    public int countPairs(TreeNode root, int distance) {
        sonPairs(root, distance);
        return ans;
    }

    public int[] sonPairs(TreeNode root, int distance) {
        if (root == null) return new int[distance];
        if (root.left == null && root.right == null) {
            int[] now = new int[distance];
            now[0] = 1;
            return now;
        }
        int[] left = sonPairs(root.left, distance);
        int[] right = sonPairs(root.right, distance);
        int[] now = new int[distance];
        for (int i = 1; i < distance; i++) {
            now[i] = left[i - 1] + right[i - 1];
        }
        for (int i = 0; i <= distance - 2; i++) {
            for (int j = distance - 2 - i; j >= 0; j--) {
                ans += left[i] * right[j];
            }
        }
        return now;

    }

    class TreeNode {
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
