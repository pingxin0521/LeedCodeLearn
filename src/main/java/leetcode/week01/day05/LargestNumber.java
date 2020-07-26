package leetcode.week01.day05;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day05
 * hyp create at 20-3-16
 **/
public class LargestNumber {
    public String largestNumber(int[] nums) {
// Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LNComparator());
        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if ("0".equals(asStrs[0])) {
            return "0";
        }

        // Build largest number from sorted array.
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}

class LNComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;
        return order2.compareTo(order1);

    }
}
