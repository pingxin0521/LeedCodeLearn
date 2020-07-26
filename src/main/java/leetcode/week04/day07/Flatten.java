package leetcode.week04.day07;

/**
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day07
 * hyp create at 20-6-25
 **/
public class Flatten {
    private Node prev = null;
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node head) {
        if (head == null) return;
        Node next = head.next;
        if (prev != null) {
            prev.next = head;
            head.prev = prev;
        }
        prev = head;
        dfs(head.child);
        head.child = null;
        dfs(next);
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
