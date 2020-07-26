package leetcode.week05.day07;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/path-crossing/
 * path-crossing
 * 判断路径是否相交:利用Set
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day07
 * hyp create at 20-7-1
 **/
public class PathCrossing {
    public boolean isPathCrossing(String path) {
        if (path == null || "".equals(path)) {
            return false;
        }
        Set<Node> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(new Node(x, y));
        int i = 0;
        while (i < path.length()) {
            char c = path.charAt(i);
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    break;
            }
            Node node = new Node(x, y);
            if (set.contains(node)) {
                return true;
            }
            set.add(node);
            i++;
        }
        return false;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
