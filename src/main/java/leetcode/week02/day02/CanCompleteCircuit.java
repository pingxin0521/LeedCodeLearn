package leetcode.week02.day02;

/**
 * https://leetcode-cn.com/problems/gas-station
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week02.day02
 * hyp create at 20-3-20
 **/
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}

