package leetcode.week05.day03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * TODO 需要理解
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class CountSmaller {
    Map<Integer, Integer> res;

    public List<Integer> countSmaller(int[] nums) {
        res = new HashMap<>();
        int[][] numsWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }
        List<Integer> ans = new LinkedList<>();
        mergeSort(numsWithIndex, 0, nums.length - 1);
        for (int n = 0; n < nums.length; n++) {
            ans.add(res.getOrDefault(n, 0));
        }
        return ans;
    }

    private void mergeSort(int[][] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        int i = lo, j = mid + 1, k = 0;
        int[][] cmp = new int[hi - lo + 1][2];
        while (i <= mid) {
            while (j <= hi && nums[j][0] < nums[i][0]) {
                cmp[k++] = nums[j++];
            }
            res.put(nums[i][1], res.getOrDefault(nums[i][1], 0) + j - mid - 1);
            cmp[k++] = nums[i++];
        }
        while (j <= hi) {
            cmp[k++] = nums[j++];
        }
        System.arraycopy(cmp, 0, nums, lo, cmp.length);
    }
}
