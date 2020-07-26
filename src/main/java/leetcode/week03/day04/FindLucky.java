package leetcode.week03.day04;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/contest/weekly-contest-182/problems/find-lucky-integer-in-an-array/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week03.day04
 * hyp create at 20-3-29
 **/
public class FindLucky {
    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i : arr) {
            if (tm.containsKey(i)) {
                Integer k = tm.get(i);
                tm.put(i, k + 1);
            } else {
                tm.put(i, 1);
            }
        }
        int res = -1;

        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key.equals(value) && res < key) {
                res = key;
            }
        }

        return res;
    }
}
