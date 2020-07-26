package leetcode.week04.day07;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 分三步走：
 * <p>
 * 获取链表中元素的个数
 * 将链表首尾相连
 * 在合适的位置断开链表
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day07
 * hyp create at 20-6-25
 **/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int num = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
            num++;
        }
        //获取实际需要移动的步数
        int step = k % num;
        //不需要移动
        if (step == 0) {
            return head;
        }
        //尾首相连
        ptr.next = head;
        return moveHelper(head, step, num);
    }

    private ListNode moveHelper(ListNode head, int step, int num) {
        int count = 0;
        ListNode temp = head;
        //找到链表需要断开的位置
        while (count < num - step - 1) {
            temp = temp.next;
            count++;
        }
        //获取结果链表的起点
        ListNode res = temp.next;
        temp.next = null;
        return res;
    }
}
