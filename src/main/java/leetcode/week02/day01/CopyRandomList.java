package leetcode.week02.day01;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day01
 * hyp create at 20-3-19
 **/
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        //复制新链表，只复制next指针，不复制random指针
        while (cur != null) {
            next = cur.next;
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = next;
        }
        cur = head;
        //复制random指针
        while (cur != null) {
            next = cur.next.next;
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        //把复制链表和源链表分开
        cur = head;
        Node newHead = cur.next;
        Node copyCur = null;
        while (cur != null) {
            //record the next node
            next = cur.next.next;
            copyCur = cur.next;
            cur.next = next;
            copyCur.next = next != null ? next.next : null;
            cur = next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
