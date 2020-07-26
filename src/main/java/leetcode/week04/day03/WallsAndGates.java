package leetcode.week04.day03;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
 * <p>
 * -1 表示墙或是障碍物
 * 0 表示一扇门
 * INF 无限表示一个空的房间。然后，我们用 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day03
 * hyp create at 20-6-21
 **/
public class WallsAndGates {
    public void wallsAndGates(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    bfs(a, i, j);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int i, int j) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i * rooms[0].length + j);
        int dist = 0;
        // 用一个集合记录已经访问过的点
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(i * rooms[0].length + j);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.poll();
                int row = cur / rooms[0].length;
                int col = cur % rooms[0].length;
                // 选取之前标记的值和当前的距离的较小值
                rooms[row][col] = Math.min(rooms[row][col], dist);

                //有四个方向进行广度遍历
                int up = (row - 1) * rooms[0].length + col;
                int down = (row + 1) * rooms[0].length + col;
                int left = row * rooms[0].length + col - 1;
                int right = row * rooms[0].length + col + 1;
                if (row > 0 && rooms[row - 1][col] > 0 && !visited.contains(up)) {
                    queue.offer(up);
                    visited.add(up);
                }
                if (col > 0 && rooms[row][col - 1] > 0 && !visited.contains(left)) {
                    queue.offer(left);
                    visited.add(left);
                }
                if (row < rooms.length - 1 && rooms[row + 1][col] > 0 && !visited.contains(down)) {
                    queue.offer(down);
                    visited.add(down);
                }
                if (col < rooms[0].length - 1 && rooms[row][col + 1] > 0 && !visited.contains(right)) {
                    queue.offer(right);
                    visited.add(right);
                }
            }
            dist++;
        }
    }

//    public static void main(String[] args) {
//        WallsAndGates wallsAndGates = new WallsAndGates();
//        int[][] arr = new int[4][4];
//        arr[0][1] = -1;
//        arr[0][2] = 0;
//        arr[1][3] = -1;
//        arr[2][1] = -1;
//        arr[2][3] = -1;
//        arr[3][1] = -1;
//        arr[3][0] = -1;
//        wallsAndGates.wallsAndGates(arr);
//        System.out.println(Arrays.deepToString(arr));
//    }

}
