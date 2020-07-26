package leetcode.week04.day01;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 K 个排序链表:O(n*log(k))
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day01
 * hyp create at 20-5-2
 **/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }

        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                queue.add(p.next);
            }
        }
        return dummy.next;

    }
}
