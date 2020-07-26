package leetcode.week05.day06;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 * <p>
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day06
 * hyp create at 20-6-29
 **/
public class FindRepeatedDnaSequences {

    /**
     * hash法
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        int L = 10, n = s.length();
        HashSet<String> seen = new HashSet<>(), output = new HashSet<>();

        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            String tmp = s.substring(start, start + L);
            if (seen.contains(tmp)) {
                output.add(tmp);
            }
            seen.add(tmp);
        }
        return new ArrayList<String>(output);
    }

    /**
     * 位操作：使用掩码实现常数时间窗口切片
     * https://leetcode-cn.com/problems/repeated-dna-sequences/solution/zhong-fu-de-dnaxu-lie-by-leetcode/
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (n <= L) {
            return new ArrayList<String>();
        }

        // rolling hash parameters: base a
        int a = 4, aL = (int) Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new
                HashMap<Character, Integer>() {{
                    put('A', 0);
                    put('C', 1);
                    put('G', 2);
                    put('T', 3);
                }};
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = toInt.get(s.charAt(i));
        }

        int bitmask = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute bitmask of the current sequence in O(1) time
            if (start != 0) {
                // left shift to free the last 2 bit
                bitmask <<= 2;
                // add a new 2-bits number in the last two bits
                bitmask |= nums[start + L - 1];
                // unset first two bits: 2L-bit and (2L + 1)-bit
                bitmask &= ~(3 << 2 * L);
            }
            // compute hash of the first sequence in O(L) time
            else {
                for (int i = 0; i < L; ++i) {
                    bitmask <<= 2;
                    bitmask |= nums[i];
                }
            }
            // update output and hashset of seen sequences
            if (seen.contains(bitmask)) {
                output.add(s.substring(start, start + L));
            }
            seen.add(bitmask);
        }
        return new ArrayList<String>(output);
    }
}
