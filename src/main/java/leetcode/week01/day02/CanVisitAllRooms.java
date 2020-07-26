package leetcode.week01.day02;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/keys-and-rooms/
 *
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class CanVisitAllRooms {
    //BFS
    //DFS also ok
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            Integer idx = queue.poll();
            List<Integer> list = rooms.get(idx);
            for (Integer i : list) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
