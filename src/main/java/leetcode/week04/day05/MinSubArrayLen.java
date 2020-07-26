package leetcode.week04.day05;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day05
 * hyp create at 20-6-23
 **/
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        //[left....right)此时这个子数组的和还没有超过正整数s
        //将nums[right]的值加入sum中,然后right++;
        //判断数据是否超过s,不是的话就继续
        //当超过s后,就开始窗口的左移,先减去nums[left],然后left++,直到和sum的值小于s为止

        int left = 0,right = 0;
        int sum = 0;
        int length = 0;
        while(right < nums.length){
            sum += nums[right++];
            if(sum >= s){

                while(sum >= s){
                    sum  -= nums[left++];
                }
                int temp = right - left + 1;
                if(length == 0 || temp < length)length = temp;
            }

        }
        return length;
    }
}
