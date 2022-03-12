package leetcode.week06.day02;

/**
 * https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day02
 * hyp create at 20-7-26 下午3:05
 **/
public class NumSplits {
    public int numSplits(String s) {
        int[] a = new int[26];
        int b = 0;
        int[] c = new int[26];
        int d = 0;
        int res = 0;
        for (char ch : s.toCharArray()) {
            int i = ch - 'a';
            c[i]++;
            if (c[i] == 1) {
                d++;
            }
        }
        char[] arr = s.toCharArray();
        for (int k = 0; k < arr.length - 1; k++) {
            char ch = arr[k];
            int i = ch - 'a';
            a[i]++;
            c[i]--;
            if (a[i] == 1) {
                b++;
            }
            if (c[i] == 0) {
                d--;
            }
            //比较
            if (b == d) {
                res++;
            }
        }
        return res;
    }
}
