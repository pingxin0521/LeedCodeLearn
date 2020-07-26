package leetcode.week04.day07;

/**
 * https://leetcode-cn.com/explore/learn/card/linked-list/195/classic-problems/752/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day07
 * hyp create at 20-6-25
 **/
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) // 与删除重复元素不一样的地方！！第一个元素 开头几个元素都是指定值的情况，需要先把这个情况排除
            head = head.next;
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val != val)
                temp = temp.next;
            else {
                ListNode cursor = temp.next;
                while (cursor.next != null && cursor.next.val == val)
                    cursor = cursor.next;
                temp.next = cursor.next;
            }
        }
        return head;
    }

}
