package leetcode.week02.day03;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-19/problems/number-of-steps-to-reduce-a-number-to-zero/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day03
 * hyp create at 20-3-21
 **/
public class NumberOfSteps {
    public int numberOfSteps(int num) {
        int c = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
            c++;
        }
        return c;
    }
}
