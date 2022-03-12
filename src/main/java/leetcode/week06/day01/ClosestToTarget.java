package leetcode.week06.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day01
 * hyp create at 20-7-26 下午2:54
 **/
public class ClosestToTarget {
    public int closestToTarget(int[] arr, int target) {
        int ans = Math.abs(arr[0] - target);
        List<Integer> valid = new ArrayList<Integer>();
        valid.add(arr[0]);
        for (int num : arr) {
            List<Integer> validNew = new ArrayList<Integer>();
            validNew.add(num);
            int last = num;
            ans = Math.min(ans, Math.abs(num - target));
            for (int prev : valid) {
                int curr = prev & num;
                if (curr != last) {
                    validNew.add(curr);
                    ans = Math.min(ans, Math.abs(curr - target));
                    last = curr;
                }
            }
            valid = validNew;
        }
        return ans;
    }
}
