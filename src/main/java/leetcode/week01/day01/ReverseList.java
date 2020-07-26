package leetcode.week01.day01;

import java.util.LinkedList;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day01
 * hyp create at 20-3-12
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList<ListNode> ll = new LinkedList<>();

        ListNode p = head;
        while (p != null) {
            ll.push(p);
            p = p.next;
        }
        head = ll.peek();
        while (!ll.isEmpty()) {
            p = ll.pop();
            p.next = ll.peek();
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}