package leetcode.week02.day01;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day01
 * hyp create at 20-3-19
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        // 增加头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode preNode = pre;

        /*循环增加排序子链表的长度
        (preNode = sortSubList(preNode, len)) != null 作为边界条件，
            意为第一次调用sortSubList就返回null，说明链表长度小于len*2，可以结束排序
        */
        for (int len = 1; (preNode = sortSubList(preNode, len)) != null; len *= 2) {
            while (preNode != null) {
                preNode = sortSubList(preNode, len);
            }
            preNode = pre;
        }
        return pre.next;
    }

    // 返回排序后的链表的最后一个节点
    ListNode sortSubList(ListNode pre, int num) {
        //当前指针位置
        int fstnum = 0, lstnum = 0;
        //当前节点
        ListNode fst = pre.next, lst = fst;

        //找到lst节点位置
        for (int i = 0; i < num; i++) {
            //fst长度不够，直接返回null，此时子链表已经是排好序的
            if (lst == null)
                return null;
            lst = lst.next;
        }
        //比较，终止条件为fstnum或lastnum大于子链表长度，或者lsatnum到达链表末尾
        while (fstnum < num && lstnum < num && lst != null) {
            if (fst.val <= lst.val) {
                pre.next = fst;
                fst = fst.next;
                fstnum++;
            } else {
                pre.next = lst;
                lst = lst.next;
                lstnum++;
            }
            pre = pre.next;
        }

        //如果fst子链表还有剩余节点，接到当前节点后面
        if (fstnum < num) {
            pre.next = fst;
            //让当前节点走到子链表末尾
            for (; fstnum < num; fstnum++)
                pre = pre.next;
            //接上后面的链表
            pre.next = lst;
        }

        //和上面类似，此时还需考虑last子链表长度小于num的情况
        if (lstnum < num && lst != null) {
            pre.next = lst;
            for (; lstnum < num && pre != null; lstnum++)
                pre = pre.next;
        }

        //返回最后一个节点，作为下次排序的pre
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}