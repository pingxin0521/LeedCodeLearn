package leetcode.week05.day04;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day04
 * hyp create at 20-6-28
 **/
public class ClimbStairs {
    /**
     * dp[0]=0
     * dp[1]=1
     * dp[2]=2
     * dp[3]=dp[2]+dp[1]
     * ...
     * dp[i]=dp[i-1]+dp[i-2]
     * ...
     * dp[n]=dp[n-1]+dp[n-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int[] dp=new int[2];
        dp[0]=1;
        dp[1]=2;
        for(int i=3;i<=n;i++){
            int t=dp[1];
            dp[1]=dp[0]+dp[1];
            dp[0]=t;
        }
        return dp[1];
    }
}
