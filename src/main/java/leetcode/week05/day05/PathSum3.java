package leetcode.week05.day05;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day05
 * hyp create at 20-6-29
 **/
public class PathSum3 {
    //O(nlog(n))
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new int[1000], 0);
    }

    public int pathSum(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = pathSum(root.left, sum, array, p + 1);
        int n2 = pathSum(root.right, sum, array, p + 1);
        return n + n1 + n2;
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
