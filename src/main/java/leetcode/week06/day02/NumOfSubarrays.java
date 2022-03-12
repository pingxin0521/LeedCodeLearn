package leetcode.week06.day02;

/**
 * https://leetcode-cn.com/problems/number-of-sub-arrays-with-odd-sum/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day02
 * hyp create at 20-7-26 下午3:02
 **/
public class NumOfSubarrays {
    /*
    这里我们需要先知道一点点前缀和的意思
        如果当前的和为1，那么找到前缀和为0的，在这一段中，和就为奇数
        因为前缀和为0的变成前缀和为1的，中间的和肯定是一个奇数
        同理，如果当前的和为0，那么找到前缀和为1的，在这一段中，和就为奇数
        我们只需要统计前缀和为0和1的个数即可
*/
    public int numOfSubarrays(int[] arr) {
        int[] cnts = new int[2];
        int cur = 0;
        int ans = 0;
        cnts[0] = 1;
        int mod = 1000000007;
        for (int x : arr) {
            //查看当前的前缀和
            cur = (cur + x) % 2;
            //结果加上前缀和相反的个数
            ans += cnts[1 - cur];
            //前缀和为cur的个数++
            cnts[cur]++;
            ans %= mod;
        }
        return ans % mod;
    }
}
