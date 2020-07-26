package leetcode.week04.day07;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * <p>
 * 1.大致思路：head指针从前向后推进，每次推进2格，分别赋给奇数链表odd和偶数链表even，最后连接 odd链表 和 even链表。
 * 2.因为使用了dummy head,所以无需关注指针为空的情况。
 * 3.唯一需要注意的就是当head链表的个数为奇数时，需要将倒数第二个节点的next指针置为null,防止成为循环链表。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day07
 * hyp create at 20-6-25
 **/
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode curOdd = odd, curEven = even;
        while (head != null) {
            curOdd.next = head;
            curOdd = curOdd.next;
            head = head.next;
            if (head != null) {
                curEven.next = head;
                curEven = curEven.next;
                head = head.next;
            } else {
                curEven.next = null;
            }
        }
        curOdd.next = even.next;
        return odd.next;
    }
}
