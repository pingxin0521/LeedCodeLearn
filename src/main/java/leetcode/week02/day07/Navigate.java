package leetcode.week02.day07;

import java.util.Scanner;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day07
 * hyp create at 20-3-25
 **/
public class Navigate {
    /*
    链接：https://ac.nowcoder.com/acm/evaluate/2598/A
来源：牛客网

现在你在牛总的公司负责给公司新开发的机器人编写寻路的算法。由于这个机器人还在开发阶段，它的移动是有限制的。为了方便说明，我们把地图抽象为一个平面直角坐标系。首先，它只能平行于两条坐标轴移动，同时它每一次移动后的地方的坐标至少有一维是整数（像(1.2,2.5)这些地方它是不能停下来的）。
还有就是它能够移动的方向是和它当前所在坐标的奇偶性有关：如果当前位置的横坐标为奇数，在竖直方向上就只可以向下走，否则就只能向上走；如果当前位置的纵坐标为奇数，在水平方向就只可以向左走，否则就只能向右走。
现在你的boss想知道这个机器人从坐标原点移动到(x,y)最少需要移动多少距离。
输入描述:
一行输入两个整数x和y，代表终点的横纵坐标。(-10^{6} \leq x,y  \leq 10^{6})(−10
6
 ≤x,y≤10
6
 )
输出描述:
输出一个整数，表示从原点到(x,y)的最短路径长度
示例1
输入
复制
0 -4
输出
复制
8
说明
路线：(0,0)->(1,0)->(1,-3)->(-1,-3)->(-1,-4)->(0,-4)
示例2
输入
复制
-69 -99
输出
复制
170
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

    }
}
