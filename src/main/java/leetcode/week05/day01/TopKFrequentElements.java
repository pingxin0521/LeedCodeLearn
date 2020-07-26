package leetcode.week05.day01;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day01
 * hyp create at 20-6-26
 **/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            maxheap.offer(m);
        }
        for (int i = 0; i < k; i++) {
            result[i] = maxheap.poll().getKey();
        }

        return result;
    }
}
