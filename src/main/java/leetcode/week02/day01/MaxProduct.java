package leetcode.week02.day01;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day01
 * hyp create at 20-3-19
 **/
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int [][] m=new int[nums.length][2];
        m[0][0]=nums[0];
        m[0][1]=nums[0];
        int max_prod=m[0][0];
        for(int i=1;i<nums.length;i++){
            m[i][0]= Math.max(Math.max(nums[i],nums[i]*m[i-1][0]),nums[i]*m[i-1][1]);
            m[i][1]=Math.min(Math.min(nums[i],nums[i]*m[i-1][0]),nums[i]*m[i-1][1]);
            max_prod=Math.max(m[i][0],max_prod);
        }
        return max_prod;
    }
}
