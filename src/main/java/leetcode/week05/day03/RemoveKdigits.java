package leetcode.week05.day03;

import java.util.LinkedList;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day03
 * hyp create at 20-6-27
 **/
public class RemoveKdigits {
    /**
     * 利用栈的贪心算法
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for (char digit : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for (int i = 0; i < k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }


    public static void main(String[] args) {
        RemoveKdigits kdigits = new RemoveKdigits();
        System.out.println(kdigits.removeKdigits("1432219", 3));
        System.out.println(kdigits.removeKdigits("100200", 1));
    }
}
