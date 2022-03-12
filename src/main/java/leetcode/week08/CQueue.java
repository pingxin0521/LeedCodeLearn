package leetcode.week08;

import java.util.LinkedList;

public class CQueue {

    private LinkedList<Integer> A =new LinkedList();
    private LinkedList<Integer> B =new LinkedList();

    public CQueue() {

    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()){
            return B.pop();
        }
        if (A.isEmpty()) {
            return -1;
        }
        while (!A.isEmpty()){
            B.push(A.pop());
        }
        return B.pop();
    }
}
