package leetcode.week05.day03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int tempEnd = points[0][1];//第一个数组的尾部作为暂时的结尾
        int count = 1;//计数初始化为1
        for (int[] point : points) {
            if (point[0] > tempEnd) {//当前数组的开头大于tempEnd
                tempEnd = point[1];
                count++;
            }
        }
        return count;
    }
}
