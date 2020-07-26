package leetcode.week01.day04;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day04
 * hyp create at 20-3-15
 **/
public class IsUgly {
    //https://leetcode-cn.com/problems/ugly-number
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }

    //https://leetcode-cn.com/problems/ugly-number-ii/
    //https://leetcode-cn.com/problems/ugly-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-9/
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1; // 丑数序列
        int index2 = 0, index3 = 0, index5 = 0; //三个指针
        for (int i = 1; i < n; i++) {
            // 三个中选择较小的
            int factor2 = 2 * ugly[index2];
            int factor3 = 3 * ugly[index3];
            int factor5 = 5 * ugly[index5];
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;//更新丑数序列
            if (factor2 == min) {
                index2++;
            }
            if (factor3 == min) {
                index3++;
            }
            if (factor5 == min) {
                index5++;
            }
        }
        return ugly[n - 1];
    }
}
