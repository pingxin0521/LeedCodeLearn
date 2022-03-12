package leetcode.week02.day01;

/**
 *https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day01
 * hyp create at 20-3-19
 **/
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // 1. 复制各节点，并构建拼接链表
        while (cur!=null){
            next = cur.next;
            Node n= new Node(cur.val);
            cur.next = n;
            n.next = next;
            cur=next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur!=null){
            if (cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head;
        Node res = head.next;
        while (cur.next!=null){
            pre.next=pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;// 单独处理原链表尾节点
        return res;// 返回新链表头节点
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
