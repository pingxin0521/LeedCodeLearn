package leetcode.week02.day03;

/**
 * https://leetcode-cn.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day03
 * hyp create at 20-3-21
 **/
public class NumOfSubarrays {
    public static void main(String[] args) {
        System.out.println(new NumOfSubarrays().numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
    }
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        long sum[] = new long[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1] + arr[i];
        }
//        01234
        int res = 0;
        for (int i = 0; i + k - 1 < sum.length; i++) {
            long tem = 0;
            if (i - 1 >= 0) {
                tem = sum[i + k - 1] - sum[i - 1];
            } else {
                tem = sum[i + k - 1];
            }

            if (tem / k >= threshold) {
                res++;
            }
        }
        return res;
    }
}
