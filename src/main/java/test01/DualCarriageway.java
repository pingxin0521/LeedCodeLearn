package test01;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：
 *
 * 1． 向右走一格，即从(x,y)到(x,y+1);
 *
 * 2． 向上右方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);
 *
 * 3． 向下右方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);
 *
 *
 *
 * 问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。
 *
 * 输入
 * 输入第一行仅包含一个正整数n，表示网格的长度。(1<=n<=50)
 *
 * 接下来有2行,每行有n个字符，“X”代表障碍物，“.”代表可以停留。
 *
 * 输出
 * 如果没有可以到达的路线则输出-1，否则输出方案数量。
 *
 *
 * 样例输入
 * 5
 * ..X.X
 * XX...
 * 样例输出
 * 2
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 20-3-12
 **/
public class DualCarriageway {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] data = new char[2][n];
        in.nextLine();
        data[0] = in.nextLine().toCharArray();
        data[1] = in.nextLine().toCharArray();
        int i = 0, j = 0;
        int count = 0;
        boolean su = false;
        LinkedList<Point> ll = new LinkedList<>();
        ll.offer(new Point(0, 0));
        while (!ll.isEmpty()) {
            int k = 0;
            boolean d = false;
            Point p = ll.pollFirst();
            if (p.x == 1 && p.y == n - 1) {
                su = true;
            }
            if (p.y + 1 < n && data[p.x][p.y + 1] != 'X') {

                Point t = new Point(p.x, p.y + 1);
                if (!t.equals(ll.peekLast())) {
                    k++;
                    ll.offer(t);
                } else {
                    d = true;
                }
            }
            if (p.x - 1 >= 0 && p.y + 1 < n && data[p.x - 1][p.y + 1] != 'X') {
                Point t = new Point(p.x - 1, p.y + 1);
                if (!t.equals(ll.peekLast())) {
                    k++;
                    ll.offer(t);
                } else {
                    d = true;
                }
            }

            if (p.x + 1 < 2 && p.y + 1 < n && data[p.x + 1][p.y + 1] != 'X') {
                Point t = new Point(p.x + 1, p.y + 1);
                if (!t.equals(ll.peekLast())) {
                    k++;
                    ll.offer(t);
                } else {
                    d = true;
                }
            }
            if (k > 1) {
                count += k;
            }
        }
        if (count != 0 && su) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
