package leetcode.week04.day07;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day07
 * hyp create at 20-6-25
 **/
public class DuplicateElements {
    /**
     * https://leetcode-cn.com/problems/contains-duplicate/
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/contains-duplicate-ii/
     * <p>
     * 通过set来记录在[l...l+k]这个区间内的元素，如果范围超出了，就去掉当前索引-k这一个元素，也就是区间的第一个元素，从而保证了滑动窗口的的大小固定
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/contains-duplicate-iii/
     *
     * 用集合+滑动窗口的方法
     * 需要注意的是这里要求两个值的差不能大于t。假设我们有一个数字v，那么满足条件的另一个数w一定在v-t——v+t这个范围内，才能保证 -t<w-v<=t
     * 所以在判断的时候可以用到TreeSet里寻找比给定数小的最大值ceiling方法或者比给定数大的最小值floor方法。然后判断这个数是否在上述区间，就可以了。
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (set.ceiling((long) nums[i] - t) != null && set.ceiling((long) nums[i] - t) - t <= nums[i])
                return true;

            set.add((long) nums[i]);
            if (set.size() == k + 1)
                set.remove((long) nums[i - k]);
        }
        return false;
    }
}
