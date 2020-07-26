package leetcode.week05.day02;

import java.util.Stack;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day02
 * hyp create at 20-6-26
 **/
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}
