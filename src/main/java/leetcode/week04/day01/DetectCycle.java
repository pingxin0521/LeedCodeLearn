package leetcode.week04.day01;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 1. set实现：节点如set，如果有重复，则说明找到开始节点
 * 2. 快慢指针：从head与meet出发，两指针速度一样，相遇时即为换的起点
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day01
 * hyp create at 20-5-3
 **/
public class DetectCycle {


    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) // 当快的游标跑到链表尾 说明没有环
            {
                return null;
            }
            fast = fast.next.next; // 只能移动两个结点，否则会跳过慢的游标
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
