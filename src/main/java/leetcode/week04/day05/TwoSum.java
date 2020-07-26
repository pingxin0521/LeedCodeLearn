package leetcode.week04.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/explore/learn/card/hash-table/205/practical-application-hash-map/811/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{1 + i, 1 + j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
