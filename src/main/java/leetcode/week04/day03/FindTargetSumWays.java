package leetcode.week04.day03;

/**
 * https://leetcode-cn.com/problems/target-sum/
 * <p>
 * 原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target
 * 我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
 * 那么让我们看看如何将其转换为子集求和问题：
 * sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 * 2 * sum(P) = target + sum(nums)
 * 因此，原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，使得sum(P) = (target + sum(nums)) / 2
 * 请注意，上面的公式已经证明target + sum(nums)必须是偶数，否则输出为0
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day03
 * hyp create at 20-6-21
 **/
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < S || (S + sum) % 2 != 0) {
            return 0;
        }
        int p = (S + sum) / 2;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[p];
    }
}
