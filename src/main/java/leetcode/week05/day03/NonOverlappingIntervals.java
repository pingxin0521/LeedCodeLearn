package leetcode.week05.day03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class NonOverlappingIntervals {
    /**
     * 问题可以转化为找到尽量多的不重叠的数组，然后用数组总数减去不重叠的数组数量。这里使用贪心算法，按照数组的末尾对数组进行排序，这样位置靠前的数组末尾越小，也就给后面的数组留了更多的空间。遍历数组，出现不重叠的数组则count++。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int tempEnd = intervals[0][1];//第一个数组的尾部作为暂时的结尾
        int count = 1;//计数初始化为1
        for (int[] interval : intervals) {
            if (interval[0]>=tempEnd){
                tempEnd=interval[1];
                count++;
            }
        }
        return intervals.length-count;
    }
}
