package leetcode.week05.day03;

import java.util.LinkedList;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class JumpingGame {

    /**
     * https://leetcode-cn.com/problems/jump-game/
     * <p>
     * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
     * <p>
     * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
     * <p>
     * 如果可以一直跳到最后，就成功了。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/jump-game-ii/
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * https://leetcode-cn.com/problems/jump-game-iii/
     *
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.removeFirst();
                int curValue = arr[curPos];
                if (curValue == 0) return true;
                int leftPos = curPos - curValue;
                if (leftPos >= 0 && !visited[leftPos]) {
                    visited[leftPos] = true;
                    queue.addFirst(leftPos);
                }
                int rightPos = curPos + curValue;
                if (rightPos < n && !visited[rightPos]) {
                    visited[rightPos] = true;
                    queue.addFirst(rightPos);
                }
            }
        }
        return false;
    }
}
