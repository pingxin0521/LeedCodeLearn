package leetcode.week02.day05;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day05
 * hyp create at 20-3-23
 **/
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int[][] arr = new int[][]{{1, 2, 3}, {3, 2, 1}, {1, 1, 5}, {2, 6, 6, 6}};
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
            permutation.nextPermutation(a);
            System.out.println(Arrays.toString(a));
        }

    }

    //从数组最后向前寻找最后升序的前一个数字。例如：[5,4,7,5,3,2]在2的位置停止升序，那么（2-1）位置上的数字就是需要交换的数字，我们需要找到（2-1）位置后面比此数字大的最小数，将他们交换，最后再从小到大排序（2-1）后面的每一位数，就得到了我们想要的结果
    //
    public void nextPermutation(int[] nums) {
        if(nums.length==0) {
            return;
        }
        int index=-1;
        int temp;
        for(int i=nums.length-1;i>0;i--) {
            if(nums[i]>nums[i-1]) {
                index=i-1;
                break;
            }
        }
        //全是降序
        if(index==-1) {
            Arrays.sort(nums);
            return;
        }
        if(index==nums.length-2) {
            temp=nums[index];
            nums[index]=nums[index+1];
            nums[index+1
                    ]=temp;
            return;
        }
        int min=index+1;
        for(int i=index+1;i<nums.length;i++) {
            if(nums[index]<nums[i]&&nums[min]>nums[i]) {
                min=i;
            }
        }
        temp=nums[index];
        nums[index]=nums[min];
        nums[min]=temp;
        Arrays.parallelSort(nums, index+1, nums.length);
    }
}
