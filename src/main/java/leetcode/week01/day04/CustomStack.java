package leetcode.week01.day04;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class CustomStack {
    private int[] stack;
    private int index;
    private int size;

    public CustomStack(int maxSize) {
        size = maxSize;
        stack = new int[maxSize];
        index = -1;
    }

    public void push(int x) {
        if (index < size - 1) {
            stack[++index] = x;
        }
    }

    public int pop() {
        if (index == -1) {
            return index;
        }
        return stack[index--];
    }

    public void increment(int k, int val) {
        int n = k > size ? size : k;
        for (int i = 0; i < n; i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack stack=new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5,100);
        stack.increment(2,100);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
