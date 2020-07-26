package test08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 双行道
 * 有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：
 * 1．    向右走一格，即从(x,y)到(x,y+1);
 * 2．    向上右方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);
 * 3．    向下右方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);
 *
 * 问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。
 * 输入描述
 * 输入第一行仅包含一个正整数n，表示网格的长度。(1<=n<=50)
 * 接下来有2行,每行有n个字符，“X”代表障碍物，“.”代表可以停留。
 * 输出描述
 * 如果没有可以到达的路线则输出-1，否则输出方案数量。
 * 示例1
 * 输入
 * 5
 * ..X.X
 * XX...
 * 输出
 * 2
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-3-18
 **/
public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[][] data = new char[2][n];
        for (
                int i = 0;
                i < 2; i++) {
            String s = in.nextLine();
            data[i] = s.toCharArray();
        }

        int count = 0;
        int i = 0, j = 0;
        Queue<Point> lhs = new LinkedList<>();
        lhs.offer(new

                Point(0, 0));
        boolean su = false;
        Point z = new Point(1, n - 1);
        while (!lhs.isEmpty()) {
            Point no = lhs.poll();
            i = no.x;
            j = no.y;
            Point t = null;
            if (j + 1 < n && data[i][j + 1] == '.') {
                t = new Point(i, j + 1);
                if (z.equals(t)) {
                    count++;
                } else {
                    lhs.offer(t);
                }
            }
            if (i + 1 < 2 && j + 1 < n && data[i + 1][j + 1] == '.') {
                t = new Point(i + 1, j + 1);
                if (z.equals(t)) {
                    count++;
                } else {
                    lhs.offer(t);
                }
            }
            if (i - 1 >= 0 && j + 1 < n && data[i - 1][j + 1] == '.') {
                t = new Point(i - 1, j + 1);
                if (z.equals(t)) {
                    count++;
                } else {
                    lhs.offer(t);
                }
            }

        }

        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
        //System.out.println(a);

    }

    static class Point {
        int x;
        int y;

        public Point(int a, int b) {
            x = a;
            y = b;
        }

        public boolean equals(Point n) {
            if (null == n || !(n instanceof Point)) {
                return false;
            }
            if (n.x == x && n.y == y) {
                return true;
            }
            return false;
        }
    }
}
