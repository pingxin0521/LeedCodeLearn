package leetcode.week04.day03;

/**
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day03
 * hyp create at 20-6-21
 **/
public class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int len;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        len = k;
        head = -1;
        tail = -1;
        data = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        //满了
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % len;
        data[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        //空了
        if (isEmpty()) {
            return false;
        }
        if (tail == head) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % len;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return ((tail + 1) % len) == head;
    }

    public static void main(String[] args) {
//        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//        circularQueue.enQueue(1);  // 返回 true
//        circularQueue.enQueue(2);  // 返回 true
//        circularQueue.enQueue(3);  // 返回 true
//        circularQueue.enQueue(4);  // 返回 false，队列已满
//        circularQueue.Rear();  // 返回 3
//        circularQueue.isFull();  // 返回 true
//        circularQueue.deQueue();  // 返回 true
//        circularQueue.enQueue(4);  // 返回 true
//        circularQueue.Rear();  // 返回 4
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        circularQueue.enQueue(7);
        circularQueue.deQueue();
        System.out.println(circularQueue.Front());
        circularQueue.deQueue();
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.Rear());
        circularQueue.enQueue(0);
        circularQueue.isFull();
        circularQueue.deQueue();
        System.out.println(circularQueue.Rear());
        circularQueue.enQueue(5);
    }
}
