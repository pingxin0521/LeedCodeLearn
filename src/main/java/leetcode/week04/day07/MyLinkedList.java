package leetcode.week04.day07;

/**
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day07
 * hyp create at 20-6-25
 **/
public class MyLinkedList {

    private Node head;
    private int len;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        len = 0;
        head = new Node(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int val = -1;
        if (index < 0 || index >= len) {
            return val;
        }
        Node p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        if (p != null) {
            val = p.val;
        }
        return val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
// If index is greater than the length,
        // the node will not be inserted.
        if (index > len) {
            return;
        }

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0) {
            index = 0;
        }

        ++len;
        // find predecessor of the node to be added
        Node pred = head;
        for (int i = 0; i < index; ++i) {
            pred = pred.next;
        }
        // node to be added
        Node toAdd = new Node(val);
        // insertion itself
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;

        --len;
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node q = p.next;
        p.next = q.next;
        q.next = null;
    }

    static class Node {
        int val;
        Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }
    }
}

