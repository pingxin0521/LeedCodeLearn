package leetcode.week01.day07;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 1. 使用set求交集
 * 2. 遍历计数，有m、n长度，m-n为后面的长度
 * 3. 循环遍历，A-》B,B->A，长度m+n=n+m,会在相交节点相遇
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day07
 * hyp create at 20-3-18
 **/
public class GetIntersectionNode {
    /**
     * 方法一
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 方法二
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int alen = getListLength(headA);
        int blen = getListLength(headB);
        if (alen > blen) {
            headA = forwardLongList(alen, blen, headA);
        } else {
            headB = forwardLongList(blen, alen, headB);
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    public int getListLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode forwardLongList(int llen, int slen, ListNode head) {
        int delta = llen - slen;
        while (head != null && delta > 0) {
            head = head.next;
            delta--;
        }
        return head;
    }


    /**
     * 方法三
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        //双指针方法
        //特判情况
        if (headA == null || headB == null) {
            return null;
        }
        //初始化 A和B的头指针
        ListNode pA = headA;
        ListNode pB = headB;
        //判定条件 如果pA 和pB相等 表示相遇（类似于从后向前遍历的方法 但是单向链表无法返回）
        while (pA != pB) {
            //如果不满足 就向后移动
            pA = pA.next;
            pB = pB.next;
            if (pA == null && pB == null) {
                return null;
            }
            //A和B到了末尾之后，继续遍历其他的链表（总长度 A+B）
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }

        }
        //如果相遇 pA和pB 相等
        return pA;
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