package leetcode.week04.day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 *
 * 示例:
 *
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 * 内部实现使用一个队列来做,判断当前队列大小和限定大小,将总和加减,之后算平均数
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day03
 * hyp create at 20-6-21
 **/
public class MovingAverage {
    private double previousSum = 0.0;
    private int maxSize;
    private Queue<Integer> currentWindow;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        currentWindow = new LinkedList<Integer>();
        maxSize = size;
    }

    public double next(int val) {
        if (currentWindow.size() == maxSize) {
            previousSum -= currentWindow.remove();
        }
        currentWindow.add(val);
        previousSum += val;
        return previousSum / currentWindow.size();
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(2));
        System.out.println(ma.next(3));
        System.out.println(ma.next(10));
        System.out.println(ma.next(8));

    }
}
