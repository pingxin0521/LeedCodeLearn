package leetcode.week01.day01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day01
 * hyp create at 20-3-12
 **/
public class MyStack {

    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
