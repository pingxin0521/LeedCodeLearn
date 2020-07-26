package leetcode.week04.day02;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 利用小顶堆的特性（堆顶元素最小），先对前K个数组元素进行"原地"建小顶堆，建完小顶堆后，堆顶的元素最小，正好是这K个元素的第K大元素。
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day02
 * hyp create at 20-5-9
 **/
public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        FindKthLargest f = new FindKthLargest();
        System.out.println(f.findKthLargest(arr, 2));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            minPQ.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] < minPQ.peek()) {
                continue;
            }
            minPQ.add(nums[i]);
            minPQ.remove();
        }
        return minPQ.remove();
    }
}
