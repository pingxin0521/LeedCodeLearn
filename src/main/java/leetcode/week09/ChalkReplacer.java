package leetcode.week09;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-54/problems/find-the-student-that-will-replace-the-chalk/
 */
public class ChalkReplacer {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 5};
        int[] arr2 = {3, 4, 1, 2};
        System.out.println(chalkReplacer(arr1, 22));
        System.out.println(chalkReplacer(arr2, 25));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int each:chalk){sum += each;}
        long nk = k % sum;
        for (int i = 0; i < chalk.length; i++) {
            if(chalk[i] > nk){return i;}
            nk = nk - chalk[i];
        }
        return 0;
    }
}
