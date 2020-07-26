package leetcode.week05.day02;

/**
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day02
 * hyp create at 20-6-26
 **/
public class ReverseList {
    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode nh = null;
        while (head != null) {
            ListNode n = head.next;
            head.next = nh;
            nh = head;
            head = n;
        }
        return nh;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int cl = n - m + 1;
        ListNode ph = null;
        ListNode res = head;
        while (head != null && --m > 0) {
            ph = head;
            head = head.next;
        }
        ListNode mlt = head;
        ListNode nh = null;
        while (head != null && cl > 0) {
            ListNode next = head.next;
            head.next = nh;
            nh = head;
            head = next;
            cl--;
        }
        mlt.next = head;
        if (ph != null) {
            ph.next = nh;
        } else {
            res = nh;
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

