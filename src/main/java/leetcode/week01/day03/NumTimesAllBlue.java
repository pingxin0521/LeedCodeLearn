package leetcode.week01.day03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in week01.day03
 * hyp create at 20-3-14
 **/
public class NumTimesAllBlue {
    //https://leetcode-cn.com/problems/bulb-switcher/
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }

    //https://leetcode-cn.com/problems/bulb-switcher-ii/
    public int flipLights(int n, int m) {
        Set<Integer> seen = new HashSet();
        n = Math.min(n, 6);
        int shift = Math.max(0, 6 - n);
        for (int cand = 0; cand < 16; ++cand) {
            int bcount = Integer.bitCount(cand);
            if (bcount % 2 == m % 2 && bcount <= m) {
                int lights = 0;
                if (((cand >> 0) & 1) > 0) {
                    lights ^= 0b111111 >> shift;
                }
                if (((cand >> 1) & 1) > 0) {
                    lights ^= 0b010101 >> shift;
                }
                if (((cand >> 2) & 1) > 0) {
                    lights ^= 0b101010 >> shift;
                }
                if (((cand >> 3) & 1) > 0) {
                    lights ^= 0b100100 >> shift;
                }
                seen.add(lights);
            }
        }
        return seen.size();
    }

    //https://leetcode-cn.com/problems/bulb-switcher-iii/
    public int numTimesAllBlue3(int[] light) {
        int m = 1, cnt = 0;
        for (int i = 0; i < light.length; i++) {
            m = Math.max(light[i], m);
            if (m == i + 1) {
                cnt++;
            }
        }
        return cnt;
    }
}
