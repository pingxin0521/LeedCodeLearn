package leetcode.week04.day07;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day07
 * hyp create at 20-6-25
 **/
public class RemoveNthFromEnd {
    /**
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode pre = d, c = d;
        for (int i = 0; i < n; i++) {
            if (c == null) {
                return null;
            }//多余代码，防止N>链表长度
            c = c.next;
        }
        while (c.next != null) {
            pre = pre.next;
            c = c.next;
        }
        pre.next = pre.next.next;
        return d.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}