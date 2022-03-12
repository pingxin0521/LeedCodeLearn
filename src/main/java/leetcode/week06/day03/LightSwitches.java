package leetcode.week06.day03;

/**
 * https://leetcode-cn.com/problems/bulb-switcher-iv/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week06.day03
 * hyp create at 20-7-26 下午3:14
 **/
public class LightSwitches {
    public int minFlips(String target) {
        char[] chars = target.toCharArray();
        int res = 0;
        char p = '0';
        for (char c : chars) {
            if (c != p) {
                res++;
                p = c;
            }
        }
        return res;
    }
}
