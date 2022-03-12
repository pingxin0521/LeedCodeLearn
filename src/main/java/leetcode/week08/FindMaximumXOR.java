package leetcode.week08;

import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
public class FindMaximumXOR {
    public static void main(String[] args) {

    }

// O(n^n)
    public int findMaximumXOR(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int val = nums[i] ^ nums[j];
                if (max<val){
                    max = val;
                }
            }
        }
        return max;
    }


    public int findMaximumXOR2(int[] nums) {
        int max = 0;
        for (int num: nums) {
            max = Math.max(max, num);
        }
        int len = 32 - Integer.numberOfLeadingZeros(max);
        Set<Integer> prefix = new HashSet<>();
        int maxXOR = 0;
        for (int i = len - 1; i >= 0; i--) {
            maxXOR <<= 1;
            int curPrefix = maxXOR | 1;
            prefix.clear();
            for (int num: nums) {
                prefix.add(num >> i);
                if (prefix.contains(num >> i ^ curPrefix)) {
                    maxXOR |= 1;
                    break;
                }
            }
        }
        return maxXOR;
    }

}
