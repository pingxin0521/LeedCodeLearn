package leetcode.week01.day02;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day02
 * hyp create at 20-3-13
 **/
public class Game {

    /**
     * https://leetcode-cn.com/problems/guess-numbers/
     *
     * @param guess
     * @param answer
     * @return
     */
    public int game(int[] guess, int[] answer) {
        int n = 0;//猜中的个数
        int len = guess.length;//前者的数组长度
        for (int i = 0; i < len; i++) {
            if (guess[i] == answer[i]) {
                n++;//如果前者数组与后者数组元素相对应，则猜中，即n加1
            }

        }
        return n;//返回去
    }
}
