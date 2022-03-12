package leetcode.week08;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {

    //解法1
    public int[] reversePrint1(ListNode head) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        ListNode p = head;
        while(p!=null){
            list.addLast(p.val);
            p = p.next;
        }
        int n = list.size();
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = list.get(n-i-1);
        }
        return res;
    }

    // 解法2
    public int[] reversePrint2(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        p = head;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[n - i - 1] = p.val;
            p = p.next;
        }
        return res;
    }

    //解法3
    public int[] reversePrint3(ListNode head) {
        if (head==null){
            return new int[]{};
        }
        if (head.next==null)
        {
            return new int[]{head.val};
        }

        int[] arr = new int[10000];//初始化最大长度的数组
        int len = 0; //记录链表真实长度
        int i =0;
        ListNode p = head; //指向头指针
        while (p != null) {
            arr[i] = p.val;
            p = p.next;
            i++;
            len++;
        }

        //反转长度为len的数组，头尾依次交换
        for (int k = 0; k <= (len-1)/2 ; k++) {
            int t = arr[k];
            arr[k] = arr[len-1-k];
            arr[len-1-k] = t;
        }
        //提取arr的前len作为新数组输出
        return Arrays.copyOf(arr,len);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
