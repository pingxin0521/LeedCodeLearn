package leetcode.week05.day07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/max-value-of-equation/
 * 思路是先判断当前位置的最大值, 再更新队列
 * 队列维护单调递减的值(满足x差值k之内的队首元素一定是最大的)
 * <p>
 * 单调性大小关键是 通过比较top(队尾) 和 i(当前位置)的元素
 * 如果Yi - Ytop >= Xi - Xtop可知, 对于后面的位置i是优于top的
 * 所以top位置要出队
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day07
 * hyp create at 20-7-1
 **/
public class MaxValueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int re = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            //从队列首部移除不满足不等式限制的项
            while (queue.size() > 0) {
                int t = queue.getFirst();
                if (points[i][0] - points[t][0] > k) {
                    queue.removeFirst();
                } else {
                    break;
                }
            }
            //更新结果
            if (queue.size() > 0)
                re = Math.max(re, points[i][0] + points[i][1] + points[queue.getFirst()][1] - points[queue.getFirst()][0]);
            //新到来一个点x1, y1, 队列尾部 x0, y0, 如果x1-x0 小于y1 - y0，说明可以使用队列尾部元素时，总可以用新点代替而结果更大
            while (queue.size() > 0) {
                int t = queue.getLast();
                if (points[i][0] - points[t][0] <= points[i][1] - points[t][1]) {
                    queue.removeLast();
                } else {
                    break;
                }
            }

            queue.addLast(i);
        }
        return re;
    }
}
