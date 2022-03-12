package leetcode.week09;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-54/problems/check-if-all-the-integers-in-a-range-are-covered/
 * @author pingxin
 */
public class IsCovered {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {3, 4},{5,6}};
        int l1=2;
        int r1=5;
        System.out.println(isCovered(arr1, l1, r1));
    }
    public static boolean isCovered(int[][] ranges, int left, int right) {
        if (ranges.length==0){
            return false;
        }
        Set<Integer> target = new HashSet<>();
        for (int i = left; i <= right; i++) {
            target.add(i);
        }
        Set<Integer> r = new HashSet<>();

        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                r.add(i);
            }
        }
        return r.containsAll(target);
    }
}
