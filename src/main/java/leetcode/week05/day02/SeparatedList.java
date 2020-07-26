package leetcode.week05.day02;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * 使用临时头结点
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day02
 * hyp create at 20-6-26
 **/
public class SeparatedList {
    public ListNode partition(ListNode head, int x) {
        ListNode lh = new ListNode(0);
        ListNode mh = new ListNode(0);
        ListNode lp = lh, mp = mh;
        while (head != null) {
            if (head.val < x) {
                lp.next = head;
                lp = lp.next;
            } else {
                mp.next = head;
                mp = mp.next;
            }
            head = head.next;
        }
        lp.next = mh.next;
        mp.next = null;
        return lh.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
