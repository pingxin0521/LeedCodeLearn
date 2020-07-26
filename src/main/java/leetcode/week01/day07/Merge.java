package leetcode.week01.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day07
 * hyp create at 20-3-18
 **/
public class Merge {
    //还是现排序然后push到list里，通过循环interval对比前后interval的结束时间和开启时间，判断是否有overlap。
    public int[][] merge(int[][] intervals) {
        // if smaller just return
        if (intervals.length <= 1) {
            return intervals;
        }
        // sort each arr base on the left element
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        // create a temp arry
        int[] currInterval = intervals[0];
        // create the output array with unknow size
        List<int[]> resArr = new ArrayList<>();
        // add the first interval
        resArr.add(currInterval);

        // loop through each interval
        for (int[] interval : intervals) {
            // create curr interval begin, end
            int currBegin = currInterval[0];
            int currEnd = currInterval[1];
            // create next interval begin, end
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            // check overlap
            if (currEnd >= nextBegin) {
                // set the bigger end
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                // iterate currInterval
                currInterval = interval;
                // add the valid interval to res
                resArr.add(currInterval);
            }
        }
        return resArr.toArray(new int[resArr.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        System.out.println(
                Arrays.deepToString(merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
        );
    }
}
