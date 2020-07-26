package leetcode.week02.day05;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day05
 * hyp create at 20-3-23
 **/
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int m = len / 2;
        ListNode q = head;
        for (int i = 0; i < m; i++) {
            q = q.next;
        }
        return q;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
