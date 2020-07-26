package leetcode.week04.day01;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day01
 * hyp create at 20-5-1
 **/
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    /**
     * 考察点：链表的熟悉程度
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0), q = head;

        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                q.next = p2;
                p2 = p2.next;
            } else {
                q.next = p1;
                p1 = p1.next;
            }
            q = q.next;
        }
        if (p1 != null) {
            q.next = p1;
        }
        if (p2 != null) {
            q.next = p2;
        }
        return head.next;
    }
}

