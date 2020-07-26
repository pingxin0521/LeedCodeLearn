package leetcode.week05.day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class SumOfMinimumIndexesOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum) {
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
