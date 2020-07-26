package leetcode.week05.day07;

/**
 * check-if-array-pairs-are-divisible-by-k
 * 检查数组对是否可以被 k 整除:
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week05.day07
 * hyp create at 20-7-1
 **/
public class CheckIfArrayPairsAreDivisibleByK {
    /**
     * 统计各余数的个数，然后进行配对
     * 利用余数进行配对，对于第一次取余小于0的元素来说，只要再加上一个k就能使其大于0
     *
     * @param arr
     * @param k
     * @return
     */
    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for (int num : arr) {
            int i = (num % k + k) % k;
            mod[i]++;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (mod[i] != mod[k - i]) {
                return false;
            }
        }
        return mod[0] % 2 == 0;
    }
}
