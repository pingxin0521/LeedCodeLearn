package leetcode.week05.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class Subset {

    /**
     * https://leetcode-cn.com/problems/subsets/
     * 回溯法
     *
     * @param nums
     * @return
     */
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }


    /**
     * 位运算法
     * https://leetcode-cn.com/problems/subsets/
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int as = 1 << nums.length;
        for (int i = 0; i < as; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    item.add(nums[j]);
                }
            }
            res.add(item);
        }
        return res;
    }

}
