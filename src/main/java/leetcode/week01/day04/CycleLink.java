package leetcode.week01.day04;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class CycleLink {
    //双指针
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) // 当快的游标跑到链表尾 说明没有环
            {
                return false;
            }
            fast = fast.next.next; // 只能移动两个结点，否则会跳过慢的游标
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
