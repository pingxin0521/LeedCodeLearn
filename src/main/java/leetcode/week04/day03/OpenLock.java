package leetcode.week04.day03;

import java.util.*;

/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/873/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day03
 * hyp create at 20-6-21
 **/
public class OpenLock {
    //用两个队列实现宽度优先遍历。队列queue1里存的是需要转动n次达到的顶点，
// queue2是和queue1里的顶点相连同时还没有遍历到的顶点。
// 当queue1的里顶点都删掉之后，接着遍历需要转动n+1次到达的顶点，
// 也就是queue2里的顶点，此时变量steps加1。
    public static int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0) {
            return -1;
        }
        String start = "0000";
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        if (deads.contains(target) || deads.contains(start)) {
            return -1;
        }
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        int steps = 0;
        queue1.offer(start);

        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            if (cur.equals(target)) {
                return steps;
            }
            //深度遍历
            List<String> nexts = getNexts(cur);
            for (String next : nexts) {
                if (!deads.contains(next) && !visited.contains(next)) {
                    visited.add(next);
                    queue2.offer(next);
                }
            }
            if (queue1.isEmpty()) {
                steps++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }

    //它的作用是根据密码锁的转动规则得到与某一状态相连的8个状态：
    private static List<String> getNexts(String cur) {
        List<String> nexts = new ArrayList<>(8);
        for (int i = 0; i < cur.length(); i++) {
            char c = cur.charAt(i);
            char nc = c == '0' ? '9' : (char) (c - 1);
            StringBuilder builder = new StringBuilder(cur);
            builder.setCharAt(i, nc);
            nexts.add(builder.toString());

            nc = c == '9' ? '0' : (char) (c + 1);
            builder.setCharAt(i, nc);
            nexts.add(builder.toString());
        }
        return nexts;
    }


}
